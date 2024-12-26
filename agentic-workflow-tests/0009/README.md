**0009. Create Functional Tests for Golf application, with Selenium**

*Act*

- Open the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application 

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/resources/application.properties
    - pom.xml
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
    - src/main/java/com/golf/app/controller/PlayerController.java
    - src/main/java/com/golf/app/service/PlayerServiceImpl.java
    - src/main/java/com/golf/app/model/Player.java
    - src/main/resources/templates/player/player-main.html
    - src/main/resources/templates/player/player-add.html
    - src/main/resources/templates/player/player-details.html
    - src/main/resources/templates/player/player-edit.html
- Enter task description:

```
Create functional tests for Golf application, use Selenium test suite.

# scope

At the this phase only player management should be tested.

# requirements

- a base class should be created to be extended by a concrete test class.
- a test should be parameterized by properties.
- the application is secured with authentication and authorization. Perform test user login for each test.
- the application functionality should be tested with the most common browsers: Chrome, Edge, Firefox. A concrete browser must be selected by a property.
- tests should executed over clean database. Do not rely on hardcoded database objects.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Make sure, Selenium dependencies added to pom.xml:

```xml
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>4.18.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-firefox-driver</artifactId>
            <version>4.18.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-edge-driver</artifactId>
            <version>4.18.1</version>
            <scope>test</scope>
        </dependency>
```

-  a base abstract class is created for functional tests. The class should be annotated with `@SpringBootTest` and `@ActiveProfiles` pointing to a functional test profile. There should be created BeforeEach method initializing Selenium WebDriver and WebDriverWait. AfterEach method should call WebDriver quit method. Protected method `login` should authentificate a test user.
- WebDriver bean configuration should be suggested to create a browser driver instance of type specified by `browser` property.
- application-functionalTest.properties should be created in src/test/resources/ and define the properties like the following ones:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/golf_test_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create-drop
test.browser=firefox
test.webDriverWaitSeconds=10
test.username=1
test.userpassword=1
```

- PlayerManagementTest class should be created. It must have methods to test showing player list, player addition, player modification, player deletion.
- modify spring.datasource properties in application-functionalTest.properties to point an actual test database and run the command `mvn clean install`. Verify that the project built successfully and all tests passed. Inspect logs and check that messages like the following ones are printed:

```
2024-12-26T15:26:37.933 [http-nio-auto-1-exec-1] INFO  c.g.app.controller.PlayerController -  Player CEB597B0-8D50-493E-9EE1-8439192AF11F John with ID 1 has been saved in the DB
2024-12-26T15:26:45.664 [http-nio-auto-1-exec-7] INFO  c.g.app.controller.PlayerController -  Player CEB597B0-8D50-493E-9EE1-8439192AF11F John with ID 1 has been updated in the DB
2024-12-26T15:26:52.389 [http-nio-auto-1-exec-1] INFO  c.g.app.controller.PlayerController -  Player CEB597B0-8D50-493E-9EE1-8439192AF11F John with ID 1 was REMOVED from DB
```

</details>


<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md).

The following manual steps are required before running the evaluation (see [template](../auto-llm-eval/manual-output-include-template.md) ):
- Update database configuration in src/test/resources/application-functionalTest.properties to make it compatible with your local environment.
- Add output of `mvn clean install` to output.md.
- Add logs printed to console to output.md.

</details>


*Additional note*

An exemplar implementation is given in the [exemplar/0009-Agentic-functional-test-exemplar-implementation.patch](exemplar/0009-Agentic-functional-test-exemplar-implementation.patch) file.
