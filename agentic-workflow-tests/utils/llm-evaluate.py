#!/usr/bin/env python3

# temporary tool to convert  TestSpec.xml to meta.yaml

import argparse
import logging
import xmltodict
import yaml


logger = logging.getLogger(__name__)


def xml_file_to_dict(file_name):
    with open(file_name, 'r') as xml_file:
        xml_data = xml_file.read()
        dict_data = xmltodict.parse(xml_data)
        return dict_data


def dump_meta_yaml(test_spec, file_name):
    asserts = test_spec['Assertion']['Assert']
    completeness = []
    accuracy = []
    for x in asserts:
        type = x['@type']
        text = x['#text']
        match type:
            case 'completeness':
                completeness.append(text)
            case 'accuracy':
                accuracy.append(text)
            case _:
                raise ValueError(f'Invalid Assert type: {type}')
    meta = {
        'metadata': {
            'scenario_id': int(test_spec['Id']),
            'scenario_name': test_spec['Title'],
            'category': test_spec['Category'],
            'experiment_date': '2025-03-07',
            'model': 'undefined',
            'input_tokens': -1,
            'output_tokens': -1,
            'experiment_duration': -1,
            'repository':test_spec['CodeRepository']
        },
        'evaluation_steps': {
            'completeness': completeness,
            'accuracy': accuracy
        }
    }

    with open(file_name, 'w', encoding='utf-8', newline='\n') as f:
        yaml.dump(meta, f, default_flow_style=False)


def main():
    parser = argparse.ArgumentParser(
        description="Evaluate benchmark scenarios with LLM."
    )

    group = parser.add_argument_group('pathes')

    group.add_argument(
        "--test-spec",
        type=str,
        required=True,
        help="Test specification file",
    )

    group.add_argument(
        "--meta-dump-file",
        type=str,
        required=False,
        help="file to dump test specification in legacy meta.yaml format",
    )

    args = parser.parse_args()

    test_spec_dict = xml_file_to_dict(args.test_spec)

    #context_files = test_spec_dict['TestSpec']['Context']['Files']['File']
    #print('context files: ')
    #print(*context_files)

    if args.meta_dump_file:
        dump_meta_yaml(test_spec_dict['TestSpec'], args.meta_dump_file)


if __name__ == "__main__":
    main()