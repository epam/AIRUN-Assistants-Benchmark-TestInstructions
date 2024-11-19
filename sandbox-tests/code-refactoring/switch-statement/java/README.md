**Switch statement refactoring test**

*Test Description*
A developer is trying to refactor a method by using a switch statement instead of an if condition

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-refactoring/switch-statement/java
- Open the MessageProcessor class
- Change the handleMessageError method to the suggested method

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project code-refactoring/switch-statement/java in IDE
- Open the MessageProcessor class
- Type at the end of the class:

```java
// Refactored handleMessageError method using a switch instead of an if
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the handleMessageError method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-refactoring/switch-statement/java project
- Open the MessageProcessor class
- Highlight the handleMessageError method
- Type in the chat window:

> Refactor the handleMessageError method to use a switch instead of an if

- Change the handleMessageError method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the MessageProcessorTest.java file to the code-refactoring/switch-statement/java/src/test/java folder
- Run tests in the MessageProcessorTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file