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
    $SCRIPT_NAME - generate diff statistics between commits

SYNOPSIS
    $SCRIPT_NAME commit1 commit2

DESCRIPTION
    Generate diff statistics between commits.
    Prints number of modified, added, deleted files and number of inserted, deleted lines.

    NOTE: The script should be launched in git working directory.
EOD
}


function print_files_diff_stat() {
    local commit1=$1
    local commit2=$2

    git diff --name-status $commit1 $commit2 | awk '$1=="M" {modified+=1}; $1=="A" {added+=1}; $1=="D" {deleted+=1} END {printf("Files:\n%d modified(M)\n%d added(A)\n%d deleted(D)\n", modified, added, deleted)}' 
}

function print_lines_diff_stat() {
    local commit1=$1
    local commit2=$2

    git diff --numstat $commit1 $commit2 | awk 'NF==3 {inserted+=$1; deleted+=$2} END {printf("Lines:\n%d insertions(+)\n%d deletions(-)\n", inserted, deleted)}'
}

function main() {
    SCRIPT_NAME=`basename $0`
    readonly SCRIPT_NAME
    nArg=$#
    if [ $nArg -lt 2 ]; then
        print_usage 2
        exit 1
    fi
    print_files_diff_stat $1 $2
    echo
    print_lines_diff_stat $1 $2
}

if ! (return 0 2> /dev/null); then
    main "$@"
fi
