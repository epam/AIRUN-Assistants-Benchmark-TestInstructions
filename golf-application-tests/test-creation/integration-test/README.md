**Integration test creation test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/api/CompetitionRestController.java
- Highlight the CompetitionRestController class
- Open the chat AI interface and enter:

> Write a set of integration tests for this controller class using Spring MockMvc framework (@WebMvcTest annotation) and Spring Security @WithMockUser annotation to simulate authenticated user. Validate the data from response and HTTP status code using MockMvcResultMatchers. Try to test as much as possible of positive and negative scenarios

- Submit the question
- Add the suggested code to class src/test/java/com/golf/app/api/CompetitionRestControllerIntegrationTest.java
- Add all required imports

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/api/CompetitionRestController.java
- Enter task description:

> There is CompetitionRestController class.
Write a set of integration tests for this controller class using Spring MockMvc framework (@WebMvcTest annotation) and Spring Security @WithMockUser annotation to simulate authenticated user.
Validate the data from response and HTTP status code using MockMvcResultMatchers.
Try to test as much as possible of positive and negative scenarios.

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Code must compile
- Tests must be created for all public methods of the class and focus on a single behavior or functionality
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that tests cover the main functionalities and edge cases of the class logic
- Check that the tests are isolated and do not depend on each other
- Run tests in the CompetitionRestControllerIntegrationTest class. Tests must pass successfully
- Run the command in the terminal:

```
mvn clean test jacoco:report
```

- Open the target/site/jacoco/index.html file. The coverage must exceed 70% for CompetitionRestControllerIntegrationTest class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file