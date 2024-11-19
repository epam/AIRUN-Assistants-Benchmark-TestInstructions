**Unit test generation with Mock test**

*Test Description*:
A developer is trying to generate unit test with mocks

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project tests-creation/unit-test-mock/java
- Open the Calculator class
- Add suggested tests to the CalculatorTest class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project tests-creation/unit-test-mock/java
- Open the Calculator class
- Highlight the Calculator class
- Type in the chat window:

> Create unit tests for the Calculator class using Mockito library

- Add suggested tests to the CalculatorTest class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Tests must be created for all public methods of the class and focus on a single behavior or functionality
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that tests cover the main functionalities and edge cases of the class logic
- Check that the tests are isolated and do not depend on each other
- Run tests in the CalculatorTest class. Tests must pass successfully

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file