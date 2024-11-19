#!/bin/bash

set -o errexit
set -o nounset

SCRIPT_NAME=`basename $0`

printUsage() {
    cat <<EOD
Usage:
    $SCRIPT_NAME output.md changed_file_1 changed_file_2 ... changed_file_N
Description:
    This script formats and writes output.md file to be evaluated by auto-llm-eval/evaluate.py

    The script should be launched in git working directory.
    The script uses git command to recognize the status of changed files:
    - untracked files are considered as added.
    - deleted files are considered as removed.
    - modified files are considered as updated.
EOD
}

nArg=$#;
if [ $nArg -lt 2 ]; then
    printUsage
    exit 1
fi

output_md=$1
shift
declare -a files=()

iArg=1;
while [ $iArg -lt $nArg ] 
do
    files+=($1)
    iArg=$((iArg + 1))
    shift 1
done

# echo "output.md=$output_md  Files: ${files[*]}"

echo -n > $output_md

for file in "${files[@]}"; do
    if [ ! -f $file ]
    then
        cat <<EOD >> $output_md

# Delete the entire $file file as it's no longer needed.
EOD

    elif ! git ls-files --error-unmatch $file > /dev/null 2>&1
    then
        cat <<EOD >> $output_md

# I suggest to create $file:

\`\`\`${file##*.}
$(cat $file)
\`\`\`
EOD

    else
        cat <<EOD >> $output_md

# I suggest the following $file changes:

\`\`\`diff
$(git diff -U100000 $file)
\`\`\`
EOD

    fi
done