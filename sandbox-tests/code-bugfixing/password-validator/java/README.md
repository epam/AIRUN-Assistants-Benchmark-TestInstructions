**Password Validation Test**

*Test Description:*

A developer is trying to fix a bug related to password validation.

*Act:*

<details> 
<summary>Bare LLM Testing Instructions:</summary>

- Open the `prompt.txt` file.
- Copy a question located in the `prompt.txt` file to the chat window.
- Submit the question.
- Open the project `code-bugfixing/password-validator/java`.
- Open the `PasswordValidator` class.
- Change the `PASSWORD_REGEX` variable to the suggested variable.
</details>

<details> 
<summary>Code Completion Instructions:</summary>

- Open the project `code-bugfixing/password-validator/java`.
- Open the `PasswordValidator` class.
- Remove the value of the `PASSWORD_REGEX` variable.
- Move the cursor to the end of the following line:

    ```java
    private static final String PASSWORD_REGEX = 
    ```

- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
</details>

<details> 
<summary>Chat IDE:</summary>

- Open the project `code-bugfixing/password-validator/java`.
- Open the `PasswordValidator` class.
- Type the following in the chat window:

    > Rewrite the PASSWORD_REGEX regular expression variable to fix the bug

- Change the `PASSWORD_REGEX` variable to the suggested variable.
</details>

*Assert Conditions:*
- The code must compile.
- Copy the `PasswordValidatorTest.java` file to the `code-bugfixing/password-validator/java/src/test/java/com/aicode/java` folder.
- Run tests in the `PasswordValidatorTest` class. All tests must pass successfully.

*Additional Note:* The correct solution is in the `correctResponse.txt` file.