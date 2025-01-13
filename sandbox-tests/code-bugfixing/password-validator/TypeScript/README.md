**Password validation test**

*Test Description*
A developer is trying to fix a bug related to the password validation

*Act:*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/password-validator/TypeScript
- Open the PasswordValidator.ts file
- Change the PASSWORD_REGEX variable to the suggested variable

</details>
<details>
<summary>Code Completion instructions:</summary>

- Open the project code-bugfixing/password-validator/TypeScript
- Open the PasswordValidator.ts file
- Type after the PASSWORD_REGEX variable:

```TypeScript
// Rewrite the PASSWORD_REGEX regular expression variable to fix the bug
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the PASSWORD_REGEX variable to the suggested variable

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/password-validator/TypeScript
- Open the PasswordValidator.ts file
- Type in the chat window:

> Rewrite the PASSWORD_REGEX regular expression variable to fix the bug

- Change the PASSWORD_REGEX variable to the suggested variable

</details>

*Assert conditions*

- Code must compile
- Copy the PasswordValidator.test.ts file to the code-bugfixing/password-validator/TypeScript/VSCode/src folder
- Install project dependencies. Run under VSCode folder:
  npm install
- Run tests under VSCode folder:
  npm test
- Code must compile
- Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file