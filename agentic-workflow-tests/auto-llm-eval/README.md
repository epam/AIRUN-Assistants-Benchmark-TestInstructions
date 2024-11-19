# Automated Evaluation of Coding Agent test results with LLMs

## Setup

- Clone the Automated LLM Evaluation Framework repository: `git clone git@github.com:epam/AIRUN-Evaluation-Framework.git`
- Setup Anaconda or Python virtual environment as described in the repository README.md .

## Evaluate Test Results

- Write generated code changes in format acceptable for the framework by running a command in a project directory: `$SCRIPTDIR/format_output_md.sh $EVALDIR/data/0008/output.md changed_file_1.java changed_file_2.java created_file_3.xml removed_file_4.json changed_file_N.properties`, where SCRIPTDIR is path to directory with the script, EVALDIR is path to agentic-workflow-tests/auto-llm-eval
- Activate Anaconda or Python virtual environment: `conda activate auto_llm_eval` or `.venv\Scripts\activate` or `source .venv/bin/activate`.
- Export Dial API key as an environmental variable: `set API_KEY=...` or `export API_KEY=...`.
- Run the evaluation of test results: `python evaluate.py --data-dir $EVALDIR/data --scenario-ranges 8 --report-path $EVALDIR/data/grading.csv`

## Assertion

- Examine accuracy.md and completeness.md created by the command in a scenario directory.
- Examine evaluation results in grading.csv .
