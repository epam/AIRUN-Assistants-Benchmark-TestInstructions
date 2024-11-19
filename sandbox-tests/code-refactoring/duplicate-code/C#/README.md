**Duplicate code refactoring test**

*Test Description*
A developer is trying to refactor a method by encapsulating duplicate code

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-refactoring/duplicate-code/C#
- Open the PaymentProcessor class
- Change the ProcessPayment method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-refactoring/duplicate-code/C#
- Open the PaymentProcessor class
- Highlight the ProcessPayment method
- Type in the chat window:

> Refactor the ProcessPayment method by encapsulating duplicate code

- Change the ProcessPayment method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the PaymentProcessorTests.cs file to the code-refactoring/duplicate-code/C#/*/duplicate-codeTests folder
- Run tests in the PaymentProcessorTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
