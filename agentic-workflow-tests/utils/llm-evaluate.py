#!/usr/bin/env python3

# temporary tool to convert  TestSpec.xml to meta.yaml

import argparse
import csv
import logging
import math
import yaml

import xml.etree.ElementTree as ET
import numpy as NUMPY

from dataclasses import dataclass
from difflib import SequenceMatcher
from enum import Enum
from typing import Self


logger = logging.getLogger(__name__)
logging.basicConfig(encoding='utf-8', level=logging.INFO)


class WeightUnit(Enum):
    HIGH   = 1.0
    MEDIUM = 0.5
    LOW    = 0.2

    @classmethod
    def from_str(cls, s: str) -> Self:
        return cls[s.upper()]


class TestStatus(Enum):
    PASSED = 1.0
    FAILED = 0.0

    @classmethod
    def from_str(cls, status: str) -> Self:
        result = None
        match status:
            case 'Pass':
                result = TestStatus.PASSED
            case 'Fail':
                result = TestStatus.FAILED
            case _:
                raise ValueError(f'Invalid Assert type: {s}')
        return result


@dataclass
class TestGrades:
    FIELD_NUMBER = 'Number'
    FIELD_COMPLEXITY = 'Complexity'
    FIELD_ITERATION_COUNT = 'Iteration Count'
    FIELD_PERFORMANCE = 'Performance'
    FIXED_FIELDS = [FIELD_NUMBER, FIELD_COMPLEXITY, FIELD_ITERATION_COUNT, FIELD_PERFORMANCE]

    number: str
    complexity: str
    iteration_count: int
    performance_grade: float | None
    grades: dict[str, float]

    def __init__(self, number: str, complexity: str, iteration_count: int,
                 performance_grade: float | None, criteria_grades: dict[str, NUMPY.float64]):
        self.number = number
        self.complexity = complexity
        self.iteration_count = iteration_count
        self.performance_grade = performance_grade
        self.grades = {key: float(value) for key, value in criteria_grades.items()}

    def to_fields_dict(self) -> dict[str, str]:
        fields = {
            self.FIELD_NUMBER: self.number,
            self.FIELD_COMPLEXITY: self.complexity,
            self.FIELD_ITERATION_COUNT: str(self.iteration_count),
            self.FIELD_PERFORMANCE: '' if self.performance_grade is None else str(self.performance_grade)
        }
        fields.update(self.grades)
        return fields

    @classmethod
    def write_test_grades_list(cls, csv_file_name: str, test_grades_list: list[Self]):
        fieldnames = cls.FIXED_FIELDS.copy()
        extrafieldnames = []
        for test_grades in test_grades_list:
            for name in test_grades.grades.keys():
                if (not name in cls.FIXED_FIELDS) and (not name in extrafieldnames):
                    extrafieldnames.append(name)
        extrafieldnames.sort()
        fieldnames.extend(extrafieldnames)
        with open(csv_file_name, 'w', newline='\n') as csv_file:
            writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
            writer.writeheader()
            for test_grades in test_grades_list:
                fields = test_grades.to_fields_dict()
                writer.writerow(fields)

    @classmethod
    def read_test_grades_list(cls, csv_file_name: str) -> list[Self]:
        result = []
        try:
            with open(csv_file_name) as csv_file:
                reader = csv.DictReader(csv_file)
                for row in reader:
                    result.append(cls.read_test_grades(row))
        except FileNotFoundError:
            logger.warning(f"The file '{csv_file_name}' was not found.")
        return result

    @classmethod
    def read_test_grades(cls, fields: dict[str, str]) -> Self:
        grades = {}
        for name, value in fields.items():
            if not name in cls.FIXED_FIELDS:
                grades[name] = float(value)
        return cls(
            fields[cls.FIELD_NUMBER],
            fields[cls.FIELD_COMPLEXITY],
            int(fields[cls.FIELD_ITERATION_COUNT]),
            float(fields[cls.FIELD_PERFORMANCE]) if fields.get(cls.FIELD_PERFORMANCE, '') != '' else None,
            grades
        )

    @classmethod
    def upsert_test_grades_list(cls, test_grades_list: list[Self], test_grades: Self):
        updated = False
        for i, item in enumerate(test_grades_list):
            if item.number == test_grades.number and item.iteration_count == test_grades.iteration_count:
                test_grades_list[i] = test_grades
                updated = True
        if not updated:
            test_grades_list.append(test_grades)

    @classmethod
    def summarize_test_grades(cls, test_grades_list: list[Self], summary_test_grades_file_name: str):
        first_test_grades_list = []
        final_test_grades_list = []
        grade_names = []
        for test_grades in test_grades_list:
            if test_grades.performance_grade:
                final_test_grades_list.append(test_grades)
            else:
                first_test_grades_list.append(test_grades)
            grade_names.extend(test_grades.grades.keys())

        grade_names = list(set(grade_names))
        summary = {}
        summary_fieldnames = []
        for grade_name in grade_names:
            grades = []
            weights = []
            for test_grades in first_test_grades_list:
                grades.append(test_grades.grades[grade_name])
                weights.append(WeightUnit.from_str(test_grades.complexity).value)
            data_values = NUMPY.array(grades)
            data_weights = NUMPY.array(weights)
            avg = NUMPY.average(data_values, weights=data_weights)
            fieldname = 'first_' + grade_name
            summary[fieldname] = avg
            summary_fieldnames.append(fieldname)

            grades = []
            weights = []
            for test_grades in final_test_grades_list:
                grades.append(test_grades.grades[grade_name])
                weights.append(WeightUnit.from_str(test_grades.complexity).value)
            data_values = NUMPY.array(grades)
            data_weights = NUMPY.array(weights)
            avg = NUMPY.average(data_values, weights=data_weights)
            fieldname = 'final_' + grade_name
            summary[fieldname] = avg
            summary_fieldnames.append(fieldname)

        grades = []
        weights = []
        for test_grades in final_test_grades_list:
            grades.append(test_grades.performance_grade)
            weights.append(WeightUnit.from_str(test_grades.complexity).value)
        data_values = NUMPY.array(grades)
        data_weights = NUMPY.array(weights)
        avg = NUMPY.average(data_values, weights=data_weights)
        fieldname = 'performance'
        summary[fieldname] = avg
        summary_fieldnames.append(fieldname)

        #print(f'summary = {summary}')
        #print(f'summary_fieldnames = {summary_fieldnames}')
        with open(summary_test_grades_file_name, 'x', encoding='utf-8', newline='\n') as file:
            writer = csv.DictWriter(file, fieldnames=summary_fieldnames)
            writer.writeheader()
            writer.writerow(summary)


@dataclass
class Assert:
    condition: str
    weight: WeightUnit

    @classmethod
    def from_element(
        cls, element
    ) -> Self:
        condition = element.text
        weight = element.attrib.get('weight', WeightUnit.HIGH.name)

        return cls(
            condition = condition.strip(),
            weight = WeightUnit.from_str(weight)
        )


@dataclass
class Criterion:
    type: str
    weight: WeightUnit
    asserts: list[Assert]

    @classmethod
    def from_element(
        cls, element
    ) -> Self:
        type = element.attrib['type']
        weight = element.attrib.get('weight', WeightUnit.HIGH.name)
        asserts = element.findall('./Assert')

        return cls(
            type = type,
            weight = WeightUnit.from_str(weight),
            asserts = [Assert.from_element(e) for e in asserts]
        )


@dataclass
class TestLogAssert:
    status: TestStatus
    reviwed_status: TestStatus
    confidence: float
    condition: str
    reasoning: str

    @classmethod
    def from_element(
        cls, element
    ) -> Self:
        status = element.find('Status').text
        reviwed_status = element.find('ReviewedStatus').text
        confidence = float(element.find('Confidence').text)
        condition = element.find('Condition').text
        reasoning = element.find('Reasoning').text

        return cls(
            status = TestStatus.from_str(status),
            reviwed_status = TestStatus.from_str(reviwed_status) if reviwed_status else None,
            confidence = confidence,
            condition = condition.strip(),
            reasoning = reasoning.strip()
        )

    def effective_status(self):
        return self.reviwed_status if self.reviwed_status else self.status


def dump_meta_yaml(test_spec_tree, file_name: str):
    test_spec = test_spec_tree.getroot()
    criteria = test_spec.findall('./Criteria/Criterion')
    completeness = []
    accuracy = []
    for criterion in criteria:
        criterion_type = criterion.get('type')
        asserts = criterion.findall('./Assert')
        for x in asserts:
            text = x.text
            match criterion_type:
                case 'completeness':
                    completeness.append(text)
                case 'accuracy':
                    accuracy.append(text)
                case _:
                    raise ValueError(f'Invalid Criterion type: {criterion_type}')
    meta = {
        'metadata': {
            'scenario_id': int(test_spec.find('Id').text),
            'scenario_name': test_spec.find('Title').text,
            'category': test_spec.find('Category').text,
            'experiment_date': '2025-03-07',
            'model': 'undefined',
            'input_tokens': -1,
            'output_tokens': -1,
            'experiment_duration': -1,
            'repository': test_spec.find('CodeRepository').text
        },
        'evaluation_steps': {
            'completeness': completeness,
            'accuracy': accuracy
        }
    }

    with open(file_name, 'w', encoding='utf-8', newline='\n') as f:
        yaml.dump(meta, f, default_flow_style=False)


def match_assert_and_test_log_assert(cr_assert: Assert, test_log_assert: TestLogAssert):
    return SequenceMatcher(a=test_log_assert.condition, b=cr_assert.condition).ratio() > 0.95


def collect_criterion_test_log_asserts(criterion: Criterion, test_log_asserts: list[TestLogAssert]):
    log_asserts = []
    for cr_assert in criterion.asserts:
        log_assert = next((log_assert for log_assert in test_log_asserts if match_assert_and_test_log_assert(cr_assert, log_assert) ), None)
        if not log_assert:
            raise ValueError(f'Not found test log assert with condition: {cr_assert.condition}')
        log_asserts.append(log_assert)
    return log_asserts


def calculate_criterion_grade(criterion: Criterion, test_log_asserts: list[TestLogAssert]):
    assert_statuses = []
    assert_weights = []
    for cr_assert in criterion.asserts:
        log_assert = next((log_assert for log_assert in test_log_asserts if match_assert_and_test_log_assert(cr_assert, log_assert) ), None)
        if not log_assert:
            raise ValueError(f'Not found test log assert with condition: {cr_assert.condition}')
        status = log_assert.reviwed_status.value if log_assert.reviwed_status else log_assert.status.value
        weight = cr_assert.weight.value
        assert_statuses.append(status)
        assert_weights.append(weight)
    data_values = NUMPY.array(assert_statuses)
    data_weights = NUMPY.array(assert_weights)
    avg = NUMPY.average(data_values, weights=data_weights)
    return avg


def calculate_criteria_grades(test_spec_tree, test_log_tree):
    test_spec = test_spec_tree.getroot()
    criterion_elements = test_spec.findall('./Criteria/Criterion')
    criteria = [Criterion.from_element(e) for e in criterion_elements]

    test_log = test_log_tree.getroot()
    test_log_assert_elements = test_log.findall('./Asserts/Assert')
    test_log_asserts = [TestLogAssert.from_element(e) for e in test_log_assert_elements]

    iCriterion = 0
    criterion_grades_weights = {}
    for criterion in criteria:
        criterion_grade = calculate_criterion_grade(criterion, test_log_asserts)
        if logger.isEnabledFor(logging.INFO):
            criterion_log_asserts = collect_criterion_test_log_asserts(criterion, test_log_asserts)
            asserts_text = '\n'.join(f'\t- {iAssert.effective_status()}: {iAssert.condition}' for iAssert in criterion_log_asserts)
            logger.info(f'Criteria[{iCriterion}] grade = {criterion_grade}:\n{asserts_text}')

        criterion_type = criterion.type
        criterion_grades_weights.setdefault(criterion_type, ([],[]))[0].append(criterion_grade)
        criterion_grades_weights[criterion_type][1].append(criterion.weight.value)

        iCriterion += 1

    criterion_grades = {}
    for criterion_type, grades_weights in criterion_grades_weights.items():
        data_values = NUMPY.array(grades_weights[0])
        data_weights = NUMPY.array(grades_weights[1])
        avg = NUMPY.average(data_values, weights=data_weights)
        criterion_grades[criterion_type] = avg
    return criterion_grades


def get_test_complexity(test_spec_tree) -> str:
    test_spec = test_spec_tree.getroot()
    complexity = test_spec.find('Complexity').text
    return complexity


def count_iterations(test_log_tree) -> int:
    test_log = test_log_tree.getroot()
    test_log_comment_elements = test_log.findall('./Refinement/Comment')
    return len(test_log_comment_elements)


def calculate_performance_grade(test_log_tree) -> float | None:
    """
    Performance Grade Formula with Threshold for 1-2 Tries:
        Grade = M * math.exp(-a * max(0, T-s))
    where:
    M: Maximum grade (e.g., 1),
    T: Try count (number of attempts),
    a: Decay rate (controls how quickly the grade decreases after the 2nd try. e.g., 0.2),
    s: Shift parameter, which shifts the steep drop to occur after s attempts (set s=1 for this case).
    """
    T = count_iterations(test_log_tree)
    if T == 0:
        return None
    M = 1.0
    a = 0.2
    s = 1
    grade = M * math.exp(-a * max(0, T-s))
    return grade


def main():
    parser = argparse.ArgumentParser(
        description="Evaluate benchmark scenarios with LLM."
    )

    group = parser.add_argument_group('pathes')

    group.add_argument(
        "--test-spec",
        type=str,
        required=False,
        help="Test specification file",
    )

    group.add_argument(
        "--meta-dump-file",
        type=str,
        required=False,
        help="file to dump test specification in legacy meta.yaml format",
    )

    group.add_argument(
        "--calculate-from-test-log",
        type=str,
        required=False,
        help="Calculate final test grade of generated solution using test results from test log file",
    )

    group.add_argument(
        "--update-test-grades-in",
        type=str,
        required=False,
        help="Update test grades with calculated ones in the given CVS file",
    )

    group.add_argument(
        "--test-nbr",
        type=str,
        required=False,
        help="Test number",
    )

    group.add_argument(
        "--test-grades",
        type=str,
        required=False,
        help="Calculated test grades CVS file",
    )

    group.add_argument(
        "--summary-test-grades",
        type=str,
        required=False,
        help="Calculated test grades CVS file",
    )


    args = parser.parse_args()

    if (args.meta_dump_file or args.calculate_from_test_log or args.update_test_grades_in):
        if not args.test_spec:
            parser.error("---test-spec is required when either --meta-dump-file or --calculate-from-test-log or --update-test-grades-in is requested")
    if args.update_test_grades_in:
        if not args.test_nbr:
            parser.error("--test-nbr is required when --update-test-grades-in is requested")
    if (bool(args.test_grades) ^ bool(args.summary_test_grades)):
        parser.error("Both --test-grades and --summary-test-grades is required when either one is requested")

    ### processing ###

    test_spec_tree = None
    if args.test_spec:
        test_spec_tree = ET.parse(args.test_spec)

    if args.meta_dump_file:
        dump_meta_yaml(test_spec_tree, args.meta_dump_file)

    criteria_grades = {}
    iteration_count = 0
    performance_grade = None
    if args.calculate_from_test_log:
        test_log_tree = ET.parse(args.calculate_from_test_log)
        criteria_grades = calculate_criteria_grades(test_spec_tree, test_log_tree)
        logger.info(f'Criteria grades = {criteria_grades}')
        iteration_count = count_iterations(test_log_tree)
        logger.info(f'Iteration_count = {iteration_count}')
        performance_grade = calculate_performance_grade(test_log_tree)
        logger.info(f'Performance grade = {performance_grade}')

    if args.update_test_grades_in:
        complexity = get_test_complexity(test_spec_tree)
        test_grades_list = TestGrades.read_test_grades_list(args.update_test_grades_in)
        test_grades = TestGrades(args.test_nbr, complexity, iteration_count, performance_grade, criteria_grades)
        TestGrades.upsert_test_grades_list(test_grades_list, test_grades)
        TestGrades.write_test_grades_list(args.update_test_grades_in, test_grades_list)

    if (args.test_grades and args.summary_test_grades):
        test_grades_list = TestGrades.read_test_grades_list(args.test_grades)
        TestGrades.summarize_test_grades(test_grades_list, args.summary_test_grades)

if __name__ == "__main__":
    main()