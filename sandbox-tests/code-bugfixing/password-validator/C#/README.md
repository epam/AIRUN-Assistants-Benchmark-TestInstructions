**Password validation test**

*Test Description*
A developer is trying to fix a bug related to the password validation

*Act:*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/password-validator/C#
- Open the PasswordValidator class
- Change the PASSWORD_REGEX variable to the suggested variable

</details>
<details>
<summary>Code Completion instructions:</summary>

- Open the project code-bugfixing/password-validator/C#
- Open the PasswordValidator class
- Type after the PASSWORD_REGEX variable:

```C#
// PASSWORD_REGEX variable with bug fix
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the PASSWORD_REGEX variable to the suggested variable

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/password-validator/C#
- Open the PasswordValidator class
- Type in the chat window:

```C#
// PASSWORD_REGEX variable with bug fix
```

- Press ENTER
- Change the PASSWORD_REGEX variable to the suggested variable

</details>

*Assert conditions*

- Code must compile
- Copy the PasswordValidatorTest.cs file to the code-bugfixing/password-validator/C#/VisualStudio/passwordValidatorTest folder
- Run tests in the PasswordValidatorTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file