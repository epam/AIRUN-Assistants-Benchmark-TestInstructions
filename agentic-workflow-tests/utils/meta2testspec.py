#!/usr/bin/env python3

import argparse
import logging
import yaml


logger = logging.getLogger(__name__)


def main():
    parser = argparse.ArgumentParser(
        description="Convert meta.yaml to TestSpec.xml"
    )

    group = parser.add_argument_group('pathes')

    group.add_argument(
        "--meta-yaml",
        type=str,
        required=True,
        help="Source meta.yaml file",
    )

    group.add_argument(
        "--test-spec-xml",
        type=str,
        required=True,
        help="Target test specification file",
    )

    args = parser.parse_args()

    meta = None
    with open(args.meta_yaml, 'r') as f:
        meta = yaml.safe_load(f)

    metadata = meta['metadata']
    scenario_id = metadata['scenario_id']
    scenario_name = metadata['scenario_name']
    category = metadata['category']
    completeness = meta['evaluation_steps']['completeness']
    accuracy = meta['evaluation_steps']['accuracy']


    with open(args.test_spec_xml, 'x', encoding='utf-8', newline='\n') as f:
        xml1 = f'''<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
<TestSpec>
    <Id>{scenario_id}</Id>
    <Title>{scenario_name}</Title>
    <Objectives>
    </Objectives>
    <Category>{category}</Category>
    <Complexity>medium</Complexity>
    <CodeRepository>https://github.com/PolinaTolkachova/golf-application</CodeRepository>
    <Stack>
        <Languages>
            <Language primary="true">Java</Language>
        </Languages>
        <Technologies>
            <Technology>???</Technology>
        </Technologies>
    </Stack>
    <Task>
<![CDATA[
]]>
    </Task>
    <Context>
        <Files>
            <File></File>
        </Files>
    </Context>
    <Arrangement>
        <Arrange>???</Arrange>
    </Arrangement>
    <Act>
        <ActStep>Submit the task and wait implementation plan is generated</ActStep>
        <ActStep>Go to the implementation plan</ActStep>
        <ActStep>Follow the implementation plan steps and modify source code following the instructions</ActStep>
    </Act>
    <TestPlan>
        <TestStep></TestStep>
        <TestStep>Build the application with the command: `mvn clean install`</TestStep>
        <TestStep>Start the application with the command: `mvn spring-boot:run`</TestStep>
        <TestStep></TestStep>
        <TestStep></TestStep>
        <TestStep></TestStep>
    </TestPlan>
    <Criteria>
'''
        f.write(xml1)
        for x in completeness:
            ixml = f'''        <Criterion type="completeness">
            <Assert weight="low">{x}</Assert>
        </Criterion>
'''
            f.write(ixml)
        for x in accuracy:
            ixml = f'''        <Criterion type="accuracy">
            <Assert weight="low">{x}</Assert>
        </Criterion>
'''
            f.write(ixml)
        xml2 = f'''
    </Criteria>
    <MetaInfo>
        <Meta></Meta>
    </MetaInfo>
</TestSpec>
'''
        f.write(xml2)


if __name__ == "__main__":
    main()