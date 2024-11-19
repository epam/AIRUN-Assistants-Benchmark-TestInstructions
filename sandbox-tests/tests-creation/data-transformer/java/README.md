**Test generation for data transformer**

*Test Description*:
A developer is trying to generate tests for a data transformer class

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project tests-creation/data-transformer/java
- Open the DataTransformer class
- Add suggested tests to the DataTransformerTest class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project tests-creation/data-transformer/java
- Open the DataTransformer class
- Highlight the DataTransformer class
- Type in the chat window:

> Create tests for all public methods of the DataTransformer class and cover both positive and negative scenarios

- Add suggested tests to the DataTransformerTest class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Tests must be created for all public methods of the class and focus on a single behavior or functionality
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that tests cover the main functionalities and edge cases of the class logic
- Check that the tests are isolated and do not depend on each other
- Run tests in the DataTransformerTest class. Tests must pass successfully
- Run the command in the terminal:

```
mvn clean test jacoco:report
```

- Open the target/site/jacoco/index.html file. The coverage must exceed 70% for DataTransformerTest class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file