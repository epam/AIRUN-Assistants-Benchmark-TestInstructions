**Implement the immutable class test**

*Test Description*
A developer is trying to refactor a class to make it immutable

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-refactoring/immutable-class/java
- Open the Player class
- Change the class implementation to the suggested implementation
- Add all necessary imports

</details>
<details>
<summary>Code Completion instructions:</summary>

- Open the project code-refactoring/immutable-class/java
- Open the Player class
- Type at the end of the class:

```java
// Rewrite the class to make it immutable using Lombok annotations
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the class implementation to the suggested implementation

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-refactoring/immutable-class/java
- Open the Player class
- Type in the chat window:

> Rewrite the code above to make it immutable using Lombok annotations

- Change the class implementation to the suggested implementation
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the PlayerTest.java file to the code-refactoring/immutable-class/java/src/test/java folder
- Run tests in the PlayerTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
