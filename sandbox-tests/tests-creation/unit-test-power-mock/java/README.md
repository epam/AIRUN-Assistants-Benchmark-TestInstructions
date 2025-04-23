**Unit test generation with PowerMock test**

*Test Description*
A developer is trying to generate unit test using PowerMock library

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project tests-creation/unit-test-power-mock/java
- Open the InvoiceService class
- Add suggested tests to the InvoiceServiceTest class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project tests-creation/unit-test-power-mock/java
- Open the InvoiceService class
- Highlight the buildInvoice method in the InvoiceService class
- Type in the chat window:

```
Implement tests applying Mockito and JUnit Jupiter libraries for the buildInvoice method of the InvoiceService class
```

- Add suggested tests to the InvoiceServiceTest class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Tests must be created for all public methods of the class and focus on a single behavior or functionality
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that tests cover the main functionalities and edge cases of the class logic
- Check that the tests are isolated and do not depend on each other
- Run tests in the InvoiceServiceTest class. Tests must pass successfully

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file