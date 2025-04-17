**Java language version update test**

*Test Description*
A developer is trying to update the Java version to 8

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-migration/language-version-upgrade/java
- Open the UserAction class
- Change the getNormalizedNames method to the suggested method

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-migration/language-version-upgrade/java in IDE
- Open the UserAction class
- Type at the end of the class:

```java
// Implemented getNormalizedNames method applying Stream API and Java 8 features
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Changed the getNormalizedNames method to the suggested method
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/language-version-upgrade/java
- Open the UserAction class
- Highlight the getNormalizedNames method
- Type in the chat window:

```
Implement the getNormalizedNames method using Stream API and Java 8 features
```

- Change the getNormalizedNames method to the suggested method

</details>

*Assert conditions*

- Copy the UserActionTest.java file to the solution-migration/language-version-upgrade/java/src/test/java folder
- Run tests in the UserActionTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file