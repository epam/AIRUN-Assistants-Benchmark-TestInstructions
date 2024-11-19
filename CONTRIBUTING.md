# Contributing to AI / RUN <sup>TM</sup> Assistants  Benchmark Test Instructions

Thank you for your interest in contributing to AI / RUN <sup>TM</sup> Engineering Benchmark! We welcome
contributions from the community to help improve and grow this benchmark.

## Getting Started

- Fork the repository on GitHub
- Clone your forked repository to your local machine

## How to Contribute

1. Check the issue tracker for open issues or create a new one to discuss your idea.
2. Once approved, create a branch for your contribution.
3. Make your changes, following our style guidelines.
4. Write or update tests as necessary.
5. Ensure all tests pass.
6. Submit a pull request.

## Submitting a Pull Request

1. Push your changes to your forked repository.
2. Navigate to the original repository and create a pull request.
3. Provide a clear description of the changes and their purpose.
4. Wait for a maintainer to review your pull request.

## Reporting Bugs

- Use the GitHub issue tracker to report bugs.
- Describe the bug in detail, including steps to reproduce.
- Include any relevant code snippets or error messages.

## Suggesting Enhancements

- Use the GitHub issue tracker to suggest enhancements.
- Clearly describe the enhancement and its potential benefits.
- Be open to discussion and feedback from maintainers and other contributors.

## Style Guidelines

- For creating an instruction for a test use already existing instructions as an example and stick to the structure and formatting defined in them

## Directory Structure

### sandbox-tests && golf-application-tests

Try to stick to the following repository structure for [sandbox-tests](sandbox-tests)
and [golf-application-tests](golf-application-tests):
<pre>
├── { category-name } // test category, i.e. code-bug-fixing
│   ├── { problem-name } // make a good problem name but concise i.e. wrong-conditional-statement
│   │   ├── { language-name } // language name i.e. java
│   │   │   ├── README.md // test description including run instructions, assert conditions, etc.
│   │   │   ├── prompt.txt // LLM prompt
│   │   │   ├── correctResponse.txt // A correct solution to compare a coding assistant suggestion with
│   │   │   ├── AnyTest.java // An unit test to validate a generated solution
</pre>
i.e.
<pre>
├── algorithms
│   ├── collections-parallel-sorting
│   │   ├── java
│   │   │   ├── README.md
│   │   │   ├── prompt.txt
│   │   │   ├── correctResponse.txt
│   │   │   ├── EcommerceSortingTest.java
</pre>

### agentic-workflow-tests

Try to stick to the following repository structure for [agentic-workflow-tests](agentic-workflow-tests):
<pre>
├── { test-number } // test number in four-digit format, i.e. 0007
│   ├── README.md // test description including run instructions, assert conditions, etc.
│   ├── ... // other files required to run test
</pre>
i.e.
<pre>
├── 0003
│   ├── README.md
│   ├── docker-compose.yml
</pre>

---

This document is subject to change. Contributors are encouraged to check for
updates regularly.

<p align="center">
  EPAM and EPAM AI/RUN <sup>TM</sup> are trademarks of EPAM Systems, Inc. 
</p>
