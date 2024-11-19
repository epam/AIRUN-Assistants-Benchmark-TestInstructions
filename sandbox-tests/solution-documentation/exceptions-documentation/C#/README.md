**Exceptions documentation test**

*Test Description*
A developer is trying to create documentation for an exception

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-documentation/exceptions-documentation/C#
- Open the Lib class
- Add the suggested implementation to the PublishArticle method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-documentation/exceptions-documentation/C#
- Open the Lib class
- Highlight the PublishArticle method
- Type in the chat window:

```
Add comments for exceptions using <exception> tag for the PublishArticle method
```

- Add the suggested implementation to the PublishArticle method

</details>

*Assert conditions*

- Copy the LibTests.cs file to the solution-documentation/exceptions-documentation/C#/*/LibTests folder
- Run tests in the LibTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file