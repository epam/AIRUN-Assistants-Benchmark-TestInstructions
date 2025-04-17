**Duplicate code refactoring test**

*Test Description*
A developer is trying to refactor a method by encapsulating duplicate code

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-refactoring/duplicate-code/java
- Open the PaymentProcessor class
- Change the processPayment method to the suggested method
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-refactoring/duplicate-code/java
- Open the PaymentProcessor class
- Highlight the processPayment method
- Type in the chat window:

```
Refactor the processPayment method by encapsulating duplicate code
```

- Change the processPayment method to the suggested method
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the PaymentProcessorTest.java file to the code-refactoring/duplicate-code/java/src/test/java folder
- Run tests in the PaymentProcessorTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
