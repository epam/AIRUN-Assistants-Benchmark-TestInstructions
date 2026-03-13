
# 0008. Refactor Golf application, replace logback logging with Log4j 2.x logging framework and SLF4J as logging facade


**Category:** solution-migration  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- XML

### Technologies

N/A


## Task

```md
Refactor Golf application, replace Logback logging with Log4j2.

# migration

Migrate Logback configuration to Log4j2 configuration.
Configure Log4j2 for performance.

# logging
Unify the application logging by using SLF4J logging facade:
- replace all other loggers with SLF4J loggers everywhere in the application.
- use Lombok annotation to declare logger whether it is used in class.
- replace printing to system standard output with SLF4J logging in all classes.

# cleanup
Cleanup unused or legacy logging configuration.
```

## Context

### Files

- `src/main/resources/application.properties`
- `src/main/resources/logback-spring.xml`
- `src/main/resources/logging.properties`
- `pom.xml`
- `src/main/java/com/golf/app/controller/PlayerController.java`
- `src/main/java/com/golf/app/controller/RoundController.java`
- `src/main/java/com/golf/app/security/CustomAccessDeniedHandler.java`
- `src/main/java/com/golf/app/security/CustomLogoutSuccessHandler.java`

## Arrangement

- Copy `logback-spring.xml` to `golf-application/src/main/resources/logback-spring.xml`
- Add the file to git index with the command: `git add src/main/resources/logback-spring.xml`
- Record the changes to the repository with the command: `git commit -m "add file logging"`

## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Copy `Log4j2ApplicationRunner.java` to `golf-application/src/main/java/com/golf/app/`.
- Build the application with the command: `mvn clean install`
- Make sure there is not logback dependency by running the command: `mvn dependency:tree -Dincludes=ch.qos.logback:*`
- Start the application with the command: `mvn spring-boot:run`
- Examine content of logs/golf-app.log

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure `spring-boot-starter-logging` is excluded from Spring Boot starter dependencies in `pom.xml`.
    - (==high==) Ensure `spring-boot-starter-log4j2` dependency is added in `pom.xml`.
    - (==high==) Ensure `com.lmax:disruptor` dependency is added in `pom.xml`.
    - (==high==) Make sure there is not Logback dependency by running `mvn dependency:tree -Dincludes=ch.qos.logback:*`.
- **completeness** (==low==)
    - (==high==) Ensure `logback-spring.xml` is deleted from `src/main/resources` folder.
    - (==high==) Ensure `logging.properties` is deleted from `src/main/resources` folder.
    - (==high==) Ensure logging properties prefixed `logging.level.` are removed from `src/main/resources/application.properties`.
- **completeness** (==high==)
    - (==high==) Ensure Log4j2 configuration file is added in `src/main/resources` folder.
    - (==high==) Log4j2 is properly configured.
    - (==high==) Ensure console appender is added in Log4j2 configuration.
    - (==high==) Ensure file appender is added in Log4j2 configuration.
    - (==high==) Ensure logger for "com.golf.app" is configured in Log4j2 configuration.
    - (==high==) Ensure logger for "org.springframework.web" is configured in Log4j2 configuration.
- **completeness** (==high==)
    - (==high==) Ensure logging is fully asynchronous in Log4j2 configuration.
    - (==high==) Ensure LMAX Disruptor is utilized in Log4j2's logging.
    - (==high==) Ensure file appender is configured as RollingRandomAccessFile in Log4j2 configuration.
    - (==high==) Ensure ALL Log4j2 loggers are configured as asynchronous.
    - (==low==) Make sure that parameterized messages are used everywhere in SLF4J logging calls to boost logging performance for disabled logging statements.
- **completeness** (==high==)
    - (==high==) Ensure `@Slf4j` annotation is added to `PlayerController` class.
    - (==high==) Ensure `LOGGER` field declaration is removed from `PlayerController` class.
    - (==high==) Ensure `PlayerController.addPlayer` method logging is changed to `log.info(...)`.
    - (==high==) Ensure `PlayerController.updatePlayer` method logging is changed to `log.info(...)`.
    - (==high==) Ensure `PlayerController.deletePlayer` method logging is changed to `log.info(...)`.
    - (==high==) Ensure `@Slf4j` annotation is added to `CustomAccessDeniedHandler` class.
    - (==high==) Ensure `CustomAccessDeniedHandler.handle` method logging is changed to `log.warn(...)`.
    - (==high==) Ensure `@Slf4j` annotation is added to `CompetitionController` class.
    - (==high==) Make sure that all calls of `System.out.println(...)` are replaced with SLF4J logging in `CompetitionController` class.
    - (==high==) Ensure `@Slf4j` annotation is added to `RoundController` class.
    - (==high==) Make sure that all calls of `System.out.println(...)` are replaced with SLF4J logging in `RoundController` class.
    - (==high==) Ensure `@Slf4j` annotation is added to `CustomLogoutSuccessHandler` class.
    - (==high==) Make sure that a call of `System.out.println(...)` are replaced with SLF4J logging in `CustomLogoutSuccessHandler` class.
- **completeness** (==high==)
    - (==high==) Verify that the application console output is given and contains the application logs.
    - (==high==) Verify that the application log file is created AND contains the application log events.
- **completeness** (==medium==)
    - (==high==) Ensure that the command `mvn clean install` output is given and contains evidence of the application successfully build.
    - (==high==) Ensure that the command `mvn spring-boot:run` output is given and contains evidence of the application successful run.
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

- See [testing-template.md](testing-template.md) for example of extra report sections.
- See samples of correct solution in the [exemplar directory](exemplar).