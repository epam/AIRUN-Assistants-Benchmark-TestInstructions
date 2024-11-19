**C# 1.0 to C# 8.0 migration test**

*Test Description*
A developer is trying to update the C# version from 1.0 to 8.0

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-migration/language-version-upgrade/C#
- Open the Lib class
- Change the Greet method to the suggested method

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-migration/language-version-upgrade/C# in IDE
- Open the Lib class
- Type at the end of the class:

```C#
// Implemented C# 8.0 method for greeting users
public string GreetNew(string name)
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Change the Greet method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/language-version-upgrade/C#
- Open the Lib class
- Highlight the Greet method
- Type in the chat window:

> Implement the Greet method using features of the C# 8.0 language version

- Change the Greet method to the suggested method

</details>

*Assert conditions*

- Copy the LibTests.cs file to the solution-migration/language-version-upgrade/C#/*/Test folder
- Run tests in the LibTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file

