**Password Validation Test**

*Test Description:*

A developer is trying to fix a bug related to password validation.

*Act:*

<details> 
<summary>Bare LLM Testing Instructions:</summary>

- Open the `prompt.txt` file.
- Copy a question located in the `prompt.txt` file to the chat window.
- Submit the question.
- Open the project `code-bugfixing/password-validator/TypeScript`.
- Open the `PasswordValidator.ts` file.
- Change the `PASSWORD_REGEX` variable to the suggested variable.
</details>

<details> 
<summary>Code Completion Instructions:</summary>

- Open the project `code-bugfixing/password-validator/TypeScript`.
- Open the `PasswordValidator.ts` file.
- Remove the `PASSWORD_REGEX` variable.
- At the beginning of the `PasswordValidator.ts` file, type the following:

    ```typescript
    private static readonly PASSWORD_REGEX: RegExp = new RegExp(
    ```

- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
</details>

<details> 
<summary>Chat IDE:</summary>

- Open the project `code-bugfixing/password-validator/TypeScript`.
- Open the `PasswordValidator.ts` file.
- Type the following in the chat window:

    > Rewrite the PASSWORD_REGEX regular expression variable to fix the bug.

- Change the `PASSWORD_REGEX` variable to the suggested variable.
</details>

*Assert Conditions:*
- The code must compile.
- Copy the `passwordValidator.test.ts` file to the `code-bugfixing/password-validator/TypeScript/VSCode/src` folder.
- Install project dependencies. In the VSCode folder, run: `npm install`.
- Run tests in the VSCode folder: `npm test`.
- All tests must pass successfully.

*Additional Note:* The correct solution is in the `correctResponse.txt` file.