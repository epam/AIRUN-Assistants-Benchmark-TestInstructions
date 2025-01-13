**Password validation test**

*Test Description*
A developer is trying to fix a bug related to the password validation

*Act:*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/password-validator/java
- Open the PasswordValidator class
- Change the PASSWORD_REGEX variable to the suggested variable

</details>
<details>
<summary>Code Completion instructions:</summary>

- Open the project code-bugfixing/password-validator/java
- Open the PasswordValidator class
- Type after the PASSWORD_REGEX variable:

```java
// Rewrite the PASSWORD_REGEX regular expression variable to fix the bug.
// The password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number, and one special character. Whitespace is not allowed.
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the PASSWORD_REGEX variable to the suggested variable

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/password-validator/java
- Open the PasswordValidator class
- Type in the chat window:

```
Rewrite the PASSWORD_REGEX regular expression variable to fix the bug.
The password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number, and one special character. Whitespace is not allowed.
```

- Change the PASSWORD_REGEX variable to the suggested variable

</details>

*Assert conditions*

- Code must compile
- Copy the PasswordValidatorTest.java file to the code-bugfixing/password-validator/java/src/test/java/com/aicode/java folder
- Run tests in the PasswordValidatorTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file