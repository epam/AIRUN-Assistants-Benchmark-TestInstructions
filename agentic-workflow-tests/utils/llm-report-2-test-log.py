#!/usr/bin/env python3

# temporary tool to convert  TestSpec.xml to meta.yaml

import argparse
import logging
import re

from epam.auto_llm_eval import EvaluationStep
from epam.auto_llm_eval import EvaluationReport


logger = logging.getLogger(__name__)


def cdata(text: str) -> str:
    if re.search(r'[\<\&]', text):
        return f'<![CDATA[{text}]]>'
    return text

def main():
    parser = argparse.ArgumentParser(
        description="Dump test log XML file from LLM reports."
    )

    group = parser.add_argument_group('pathes')

    group.add_argument(
        "--llm-reports",
        type=str,
        action="extend",
        nargs="+",
        required=True,
        help="LLM report file(s)",
    )

    group.add_argument(
        "--test-log-file",
        type=str,
        required=True,
        help="test log file (in XML format)",
    )

    args = parser.parse_args()

    llm_reports = args.llm_reports
    test_log_file = args.test_log_file

    steps = []
    for report_file in llm_reports:
        logger.info(f'Process report: {report_file}')
        content = ''
        with open(report_file, "r", encoding="utf-8") as f:
            content = f.read()
        report = EvaluationReport(content)
        steps.extend(report.get_steps())

    with open(test_log_file, 'x', encoding='utf-8', newline='\n') as f:
        xml1 = f'''<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
<TestLog>
    <Asserts>
'''
        f.write(xml1)
        for step in steps:
            name = cdata(step.name)
            reasoning = '' if step.reasoning is None else cdata(step.reasoning)
            f.write(f'''
        <Assert>
            <Status>{step.status}</Status>
            <ReviewedStatus></ReviewedStatus>
            <ReviewCause></ReviewCause>
            <Confidence>{step.confidence}</Confidence>
            <Condition>{name}</Condition>
            <Reasoning>
            {reasoning}
            </Reasoning>
        </Assert>
''')
        xml2 = f'''
    </Asserts>
    <Refinement>
        <!--
        <Comment>
<![CDATA[
]]>
        </Comment>
        <Comment>
        </Comment>
        -->
    </Refinement>
    <DiffStat>
    </DiffStat>
</TestLog>
'''
        f.write(xml2)


if __name__ == "__main__":
    main()