**0015. Add Zipkin-backed Tracing to Golf application**

*Act*

- Open the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application
- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/resources/application.properties
- Enter task description:

```
Add tracing support to to Golf application.

Use Zipkin as tracer implementation.

Configure tracing to sample 100% of requests.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Setup Test Environment*

Start Zipkin either as Java jar:

```bash
java -jar zipkin.jar
```

or via Docker:

```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

*Assertion*


<details>
<summary>Manual Assertion:</summary>
- Make sure that the following dependencies added to pom.xml:
    - org.springframework.boot:spring-boot-starter-actuator
    - io.micrometer:micrometer-tracing-bridge-brave
    - io.zipkin.reporter2:zipkin-reporter-brave
- Make sure that the following properties configured in src/main/resources/application.properties:
    - management.tracing.sampling.probability=1.0
    - management.zipkin.tracing.endpoint=http://localhost:9411/api/v2/spans
- Make sure that the application is built without errors
- Make sure that the application is launched without errors
- Open application at http://localhost:8082/ and login
- Verify that traces appeared in the Zipkin UI at http://localhost:9411/zipkin

</details>

<details>
<summary>Automated LLM Assertion:</summary>
Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md) and extra steps described below.

- Launch the application
- Login to the application
- Verify that traces appeared in the Zipkin UI at http://localhost:9411/zipkin
- Add results of the manual tests to output.md. See (manual-testing-template.md)[manual-testing-template.md].

</details>

