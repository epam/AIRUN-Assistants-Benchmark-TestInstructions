
# 0015. Add Zipkin-backed Tracing to Golf application


**Category:** solution-or-component-generation  
**Complexity:** low  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

N/A


## Task

```md
Add tracing support to to Golf application.

Use Zipkin as tracer implementation.

Configure tracing to sample 100% of requests.
```

## Context

### Files

- `pom.xml`
- `src/main/resources/application.properties`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Start Zipkin either as Java jar:

```bash
java -jar zipkin.jar
```

or via Docker:

```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

        
- Update Zipkin tracing endpoint property in application.properties to match it your local environment
- Build the application with the command: `mvn clean install`
- Start the application with the command: `mvn spring-boot:run`
- Open the application at http://localhost:8082/ and login
- Verify that traces appeared in the Zipkin UI at http://localhost:9411/zipkin
- Add results of the manual tests to output.md. See (testing-template.md)[testing-template.md]

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure that `org.springframework.boot:spring-boot-starter-actuator` dependency has been added added to `pom.xml`
    - (==high==) Ensure that `io.micrometer:micrometer-tracing-bridge-brave` dependency has been added added to `pom.xml`
    - (==high==) Ensure that `io.zipkin.reporter2:zipkin-reporter-brave` dependency has been added added to `pom.xml`
- **completeness** (==high==)
    - (==high==) Ensure that `management.tracing.sampling.probability=1.0` property has been configured in `src/main/resources/application.properties`
    - (==high==) Ensure that `management.zipkin.tracing.endpoint=http://localhost:9411/api/v2/spans` property has been configured in src/main/resources/application.properties`
    - (==high==) Make sure that the application is opened at http://localhost:8082/
    - (==high==) Make sure that an user has logged in in the application
    - (==high==) Verify that traces have been appeared in the Zipkin UI at http://localhost:9411/zipkin
- **accuracy** (==high==): __functionality__
    - (==high==) Ensure that the CHANGED code accomplishes the intended functionality.
    - (==high==) Ensure that the CHANGED code handles potential edge cases, exceptions, or invalid inputs gracefully where it is required.
- **accuracy** (==high==): __adherence to task requirements__
    - (==high==) Make sure that the CHANGES are primarily made to achieve the intended functionality.
    - (==high==) Make sure that the CHANGES do not contain unrequested modifications, unused imports or code.
- **accuracy** (==high==): __code quality__
    - (==high==) Ensure that the CHANGED code is syntactically correct, compiles without errors.
    - (==high==) Ensure that the CHANGED code follows project style guides and maintain consistency with the existing codebase.
    - (==high==) Ensure that the CHANGED code is clean, readable, adheres to best practices and naming conventions.
    - (==high==) Ensure that the CHANGED code is easily maintainable, with proper structure and separation of concerns.
    - (==high==) Make sure that Spring Boot's features such as dependency injection, auto-configuration, and data access abstraction are properly utilized in the the CHANGED code.
- **accuracy** (==high==): __documentation__
    - (==high==) Ensure that the CHANGED code is well-documented, with clear and concise documentation for each part of the code.
- **accuracy** (==high==): __security__
    - (==high==) Ensure that CHANGED code keeps application secure by using proper authentication, authorization, and data validation techniques.
    - (==high==) Ensure that CHANGED code avoids exposing sensitive data.
    - (==high==) Ensure that CHANGED code protects the application from common security vulnerabilities.
- **accuracy** (==high==): __configuration__
    - (==high==) Ensure that CHANGED application configuration is flexible and externalized to efficiently manage different environments.

## Additional Notes

N/A
