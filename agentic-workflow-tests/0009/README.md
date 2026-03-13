
# 0009. Create Functional Tests for Golf application, with Selenium


**Category:** test-creation  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- HTML

### Technologies

- Selenium

## Task

```md
Create functional tests for Golf application, use Selenium test suite.

# scope

At the this phase only player management should be tested.

# requirements

- a base class should be created to be extended by a concrete test class.
- a test should be parameterized by properties.
- the application is secured with authentication and authorization. Perform test user login for each test.
- the application functionality should be tested with the most common browsers: Chrome, Edge, Firefox. A concrete browser must be selected by a property.
- tests should not rely on hardcoded database objects.
```

## Context

### Files

- `pom.xml`
- `src/main/resources/application.properties`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/java/com/golf/app/controller/PlayerController.java`
- `src/main/java/com/golf/app/service/PlayerServiceImpl.java`
- `src/main/java/com/golf/app/model/Player.java`
- `src/main/resources/templates/player/player-main.html`
- `src/main/resources/templates/player/player-add.html`
- `src/main/resources/templates/player/player-details.html`
- `src/main/resources/templates/player/player-edit.html`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Examine Selenium dependencies by running the command: `mvn dependency:tree -Dincludes=org.seleniumhq.selenium:*`
- Run the application tests with the command: `mvn clean compile test`
- Add the command output to output.md. See [testing-template.md](testing-template.md)

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure org.seleniumhq.selenium:selenium-java dependency is added in `pom.xml`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure org.seleniumhq.selenium:selenium-chrome-driver dependency is added in `pom.xml`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure org.seleniumhq.selenium:selenium-firefox-driver dependency is added in `pom.xml`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure org.seleniumhq.selenium:selenium-edge-driver dependency is added in `pom.xml`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure a base abstract class is created for functional tests.
    - (<mark>high</mark>) Make sure the base abstract class is annotated with `@SpringBootTest` and configured to use a random port.
    - (<mark>high</mark>) Make sure the base abstract class is annotated with `@ActiveProfiles` pointing to a functional test profile.
    - (<mark>high</mark>) Make sure the base abstract class has BeforeEach method initializing Selenium WebDriver and WebDriverWait.
    - (<mark>high</mark>) Make sure the base abstract class has AfterEach method calling WebDriver quit method.
    - (<mark>high</mark>) Make sure the base abstract class has a protected `login` method authentificating a test user.
    - (<mark>high</mark>) Make sure WebDriver is initialized for the browser specified by the browser property.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure a properties file for functional test profile is created in `src/test/resources/` directory.
    - (<mark>high</mark>) Make sure the functional test properties file defines tested browser, user name, user password.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure player management test class is created.
    - (<mark>high</mark>) Make sure the player management test class defines method testing application shows player list successfully.
    - (<mark>high</mark>) Make sure the player management test class defines method testing application adds player successfully.
    - (<mark>high</mark>) Make sure the player management test class defines method testing application modifies player successfully.
    - (<mark>high</mark>) Make sure the player management test class defines method testing application deletes player list successfully.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that the command `mvn clean compile test` output is given and contains evidence of the application successfully built and all tests passed.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure the player addition test passed.
    - (<mark>high</mark>) Make sure the player edition test passed.
    - (<mark>high</mark>) Make sure the player deletion test passed.
- **accuracy** (<mark>high</mark>): _functionality_
    - (<mark>high</mark>) Ensure that the CHANGED code accomplishes the intended functionality.
    - (<mark>high</mark>) Ensure that the CHANGED code handles potential edge cases, exceptions, or invalid inputs gracefully where it is required.
- **accuracy** (<mark>high</mark>): _adherence to task requirements_
    - (<mark>high</mark>) Make sure that the CHANGES are primarily made to achieve the intended functionality.
    - (<mark>high</mark>) Make sure that the CHANGES do not contain unrequested modifications, unused imports or code.
- **accuracy** (<mark>high</mark>): _code quality_
    - (<mark>high</mark>) Ensure that the CHANGED code is syntactically correct, compiles without errors.
    - (<mark>high</mark>) Ensure that the CHANGED code follows project style guides and maintain consistency with the existing codebase.
    - (<mark>high</mark>) Ensure that the CHANGED code is clean, readable, adheres to best practices and naming conventions.
    - (<mark>high</mark>) Ensure that the CHANGED code is easily maintainable, with proper structure and separation of concerns.
    - (<mark>high</mark>) Make sure that Spring Boot's features such as dependency injection, auto-configuration, and data access abstraction are properly utilized in the the CHANGED code.
- **accuracy** (<mark>high</mark>): _documentation_
    - (<mark>high</mark>) Ensure that the CHANGED code is well-documented, with clear and concise documentation for each part of the code.
- **accuracy** (<mark>high</mark>): _security_
    - (<mark>high</mark>) Ensure that CHANGED code keeps application secure by using proper authentication, authorization, and data validation techniques.
    - (<mark>high</mark>) Ensure that CHANGED code avoids exposing sensitive data.
    - (<mark>high</mark>) Ensure that CHANGED code protects the application from common security vulnerabilities.
- **accuracy** (<mark>high</mark>): _configuration_
    - (<mark>high</mark>) Ensure that CHANGED application configuration is flexible and externalized to efficiently manage different environments.

## Additional Notes

- See [testing-template.md](testing-template.md) for example of extra report sections.
- See sample of correct solution in the [exemplar directory](exemplar).