**Unit test creation for password generation test**

*Test Description*:
A developer is trying to create unit test for password generation

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project tests-creation/password-generator/C#
- Open the PwdTools class
- Add suggested tests to the PwdToolsTests class
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project tests-creation/password-generator/C#
- Open the PwdTools class
- Type after the GenerateRandomPassword method definition:
- Start typing:

```C#
[Test]
public void GenerateRandomPassword_OnlyLowercaseLetters()
{
```

- Press ENTER key
- Accept a sequence of suggestions using the TAB and ENTER keys
- Start typing:

```C#
[Test]
public void GenerateRandomPassword_OnlyUppercaseLetters()
{
```

- Press ENTER key
- Accept a sequence of suggestions using the TAB and ENTER keys
- Start typing:

```C#
[Test]
public void GenerateRandomPassword_OnlyDigits()
{
```

- Press ENTER key
- Accept a sequence of suggestions using the TAB and ENTER keys
- Start typing:

```C#
[Test]
public void GenerateRandomPassword_OnlySpecialCharacters()
{
```

- Press ENTER key
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add suggested tests to the PwdToolsTests class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project tests-creation/password-generator/C#
- Open the PwdTools class
- Highlight the PwdTools class
- Type in the chat window:

> Implement unit tests for the GenerateRandomPassword method using nUnit

- Add suggested tests to the PwdToolsTests class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Run tests in the PwdToolsTests class. Tests must pass successfully
- Run the command in the terminal:

```
dotnet test /p:CollectCoverage=true /p:CoverletOutputFormat=cobertura
```

- Check the test coverage at the terminal output. The coverage must exceed 70% for PwdToolsTests class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file