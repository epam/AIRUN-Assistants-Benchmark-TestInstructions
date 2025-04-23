**Unhandled exception test**

*Test Description*
A developer is trying to fix a bug related to an unhandled exception

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/unhandled-exception/C#
- Open the BankAccount class
- Change the CheckBalance method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/unhandled-exception/C#
- Open the BankAccount class
- Highlight the BankAccount class
- Type in the chat window:

```
Fix the CheckBalance method to be able to handle exceptions by printing them to the console
```

- Change the CheckBalance method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the BankAccountTests.cs file to the code-bugfixing/unhandled-exception/C#/*/Test folder
- Run tests in the BankAccountTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file