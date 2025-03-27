#!/usr/bin/env bash

if [[ ${DEBUG-} =~ ^1|yes|true$ ]]; then
    set -o xtrace
fi

if ! (return 0 2> /dev/null); then
    set -o errexit
    set -o nounset
    set -o pipefail
    shopt -s extglob
fi

print_usage() {
    local FD="${1:-1}"
    cat <<EOD >&$FD
NAME
    $SCRIPT_NAME - prepare agent generated changes for LLM evaluation

SYNOPSIS
    $SCRIPT_NAME commit1 commit2 test_spec_xml

DESCRIPTION
    Prepare text describing test task, task related files content, agent generated changes in LLM-readable format.
    The test task description and task related file names are readed from test_spec_xml file.
    The script uses git command to recognize the status of changed files between the given commits
    and to get the corresponding files changes.
    NOTE: The script should be launched in git working directory.
EOD
}

function format_addition() {
    local file="$2"
    local commit2="$4"
    cat <<EOD
## I suggest to create $file:

\`\`\`${file##*.}
$(git show $commit2:$file)
\`\`\`

EOD
}

function format_deletion() {
    local file="$2"
    cat <<EOD
## Delete the entire $file file as it's not longer needed.

\`\`\`diff
$(git diff -U100000 $commit1..$commit2 -- $file)
\`\`\`

EOD
}

function format_modification() {
    local file="$2"
    local commit1="$3"
    local commit2="$4"
    cat <<EOD
## I suggest the following $file changes:

\`\`\`diff
$(git diff -U100000 $commit1..$commit2 -- $file)
\`\`\`

EOD
}

function format_unrecognized() {
    local file="$2"
    local status="$1"
    echo "unrecognized change: $status $file" >&2
}

declare -rA file_change_formatters=(
    ["A"]="format_addition"
    ["D"]="format_deletion"
    ["M"]="format_modification"
)

function read_context_files() {
    local test_spec_xml=$1
    local -n files=$2
    readarray -t files < <(xmlstarlet sel --text --template --value-of /TestSpec/Context/Files/File $test_spec_xml)
}

function read_task() {
    local test_spec_xml=$1
    local -n task_desc=$2
    local s LC_CTYPE=C
    s=$(xmlstarlet sel --template --value-of /TestSpec/Task $test_spec_xml)
    # trim leading spaces
    s="${s##+([[:space:]])}"
    # trim trailing spaces
    task_desc="${s%%+([[:space:]])}"
}

function array_substruct() {
    local -n minuend=$1
    local -n subtrahend=$2
    local -n difference=$3

    difference=()
    for i in ${minuend[@]}; do
        for j in ${subtrahend[@]}; do
            if [ "${i}" == "${j}" ]; then
                continue 2
            fi
        done
        difference+=(${i})
    done
}

function cat_file() {
    local file="$1"
    local commit="$2"
    cat <<EOD
## Unchanged File $file:

\`\`\`${file##*.}
$(git show $commit:$file)
\`\`\`

EOD
}

function format_patch() {
    local commit1=$1
    local commit2=$2
    local test_spec_xml=$3

    local task
    read_task $test_spec_xml task
    cat <<EOD
# I have got the task:

\`\`\`md
$task
\`\`\`

EOD

    local context_files
    read_context_files $test_spec_xml context_files

    local file_statuses
    readarray -t file_statuses < <(git diff --name-status $commit1 $commit2)

    cat <<EOD
# Suggested Changes

EOD

    local file_status status file formatter
    local changed_files=()
    for file_status in "${file_statuses[@]}"; do
        read -r status file <<< $file_status
        formatter=${file_change_formatters[$status]:-"format_unrecognized"}
        $formatter $status $file $commit1 $commit2
        changed_files+=($file)
    done

cat <<EOD
# Code Context

EOD
    local unchanged_files=()
    array_substruct context_files changed_files unchanged_files
    for file in "${unchanged_files[@]}"; do
        cat_file $file $commit2
    done
}

function main() {
    SCRIPT_NAME=`basename $0`
    readonly SCRIPT_NAME
    nArg=$#
    if [ $nArg -lt 3 ]; then
        print_usage 2
        exit 1
    fi
    format_patch $1 $2 $3
}

if ! (return 0 2> /dev/null); then
    main "$@"
fi
