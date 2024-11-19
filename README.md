# AI/RUN Assistants Benchmark TestInstructions


The repository contains instructions to run tests evaluating AI Code Assistants performance. It is part of AI/RUN <sup>TM</sup> Engineering Benchmark. See more details in [AI/RUN <sup>TM</sup> Engineering Benchmark repo](https://github.com/epam/AIRUN-Engineering-Benchmark)  to understand the whole picture on what the benchmark is and what repositories are involved. The reasoning of keeping this repository separate from tests code was the observation that some code assistants can index test instructions and right answers examples - hence we deliberately recommend to check out instructions and tests code into distant folders on your computers.

There are the following kinds of tests:
- [sandbox-tests](sandbox-tests) - common development tasks tests divided in several categories like algorithms, code-bugfixing, code-refactoring, etc. They are targeted to run in isolated code projects containing a few source files.
- [golf-application-tests](golf-application-tests) - tests for the small golf application project containing about a hundred of source files. They are targeted to run in a rather big application context consisting of dozens source artifacts.
- [agentic-workflow-tests](agentic-workflow-tests) - tests to evaluate performance of AI Coding agents.

## Contributing

We appreciate all contributions to improve the AI/RUN <sup>TM</sup> Engineering Benchmark. Please see
our [Contribution Guidelines](CONTRIBUTING.md) for more information on how to get involved.

If you have suggestions for new benchmark scenarios or improvements to existing ones, please open an issue or submit a pull request.


## License

This project is licensed under the [Apache 2.0](/LICENSE).

<p align="center">
  EPAM and EPAM AI/RUN <sup>TM</sup> are trademarks of EPAM Systems, Inc. 
</p>
