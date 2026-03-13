
# 0006. Migrate Golf application to Spring Boot 3.5


**Category:** code-refactoring  
**Complexity:** low  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

- Spring Boot

## Task

```md
Upgrade the Golf Application from Spring Boot 3.2.1 to Spring Boot 3.5.x,
including the replacement of deprecated features with modern alternatives
and adoption of new Spring Boot 3.5 capabilities.

Make the minimal viable upgrade - Spring Boot 3.5 and fix deprecated features.
```

## Context

### Files

- `pom.xml`
- `src/main/java/com/golf/app/api/CompetitionRestController.java`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/resources/application.properties`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to match it with your local environment
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run`

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure `spring-boot-starter-parent` version is changed to `3.5.x` in `pom.xml`.
    - (==high==) Ensure `springfox-swagger2` dependency is removed in `pom.xml`.
    - (==high==) Ensure `springdoc-openapi-starter-webmvc-ui` dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure that Spring Boot managed dependency versions are not overridden in `pom.xml`.
    - (==low==) Ensure `maven-compiler-plugin` configuration `source` and `target` properties a changed to `17` in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure that `.csrf().disable()` is replaces with `.csrf(csrf -> csrf.disable())` in `AppSecurityConfig.filterChain` method.
- **completeness** (==high==)
    - (==high==) Make sure that the application is built without errors
    - (==high==) Make sure that the application is launched without errors
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

- See [testing-template.md](testing-template.md)