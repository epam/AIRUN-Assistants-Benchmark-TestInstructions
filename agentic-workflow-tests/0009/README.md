
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
- Add the command output to output.md. See (testing-template.md)[testing-template.md]

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure org.seleniumhq.selenium:selenium-java dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure org.seleniumhq.selenium:selenium-chrome-driver dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure org.seleniumhq.selenium:selenium-firefox-driver dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure org.seleniumhq.selenium:selenium-edge-driver dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure a base abstract class is created for functional tests.
    - (==high==) Make sure the base abstract class is annotated with `@SpringBootTest` and configured to use a random port.
    - (==high==) Make sure the base abstract class is annotated with `@ActiveProfiles` pointing to a functional test profile.
    - (==high==) Make sure the base abstract class has BeforeEach method initializing Selenium WebDriver and WebDriverWait.
    - (==high==) Make sure the base abstract class has AfterEach method calling WebDriver quit method.
    - (==high==) Make sure the base abstract class has a protected `login` method authentificating a test user.
    - (==high==) Make sure WebDriver is initialized for the browser specified by the browser property.
- **completeness** (==high==)
    - (==high==) Ensure a properties file for functional test profile is created in `src/test/resources/` directory.
    - (==high==) Make sure the functional test properties file defines tested browser, user name, user password.
- **completeness** (==high==)
    - (==high==) Ensure player management test class is created.
    - (==high==) Make sure the player management test class defines method testing application shows player list successfully.
    - (==high==) Make sure the player management test class defines method testing application adds player successfully.
    - (==high==) Make sure the player management test class defines method testing application modifies player successfully.
    - (==high==) Make sure the player management test class defines method testing application deletes player list successfully.
- **completeness** (==high==)
    - (==high==) Ensure that the command `mvn clean compile test` output is given and contains evidence of the application successfully built and all tests passed.
- **completeness** (==high==)
    - (==high==) Make sure the player addition test passed.
    - (==high==) Make sure the player edition test passed.
    - (==high==) Make sure the player deletion test passed.
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
- See sample of correct solution in the [exemplar directory](exemplar).