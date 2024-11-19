**API documentation test**

*Test Description*
A developer is trying to create API documentation for a method

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-documentation/api-get-method-summary/C#
- Open the SocialMediaStatsController class
- Add the suggested documentation to the GetMostTrendingSM method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-documentation/api-get-method-summary/C#
- Open the SocialMediaStatsController class 
- Highlight the GetMostTrendingSM method
- Type in the chat window:

```
Implement a <summary> documentation section for the GetMostTrendingSM method
```

- Add the suggested documentation to the GetMostTrendingSM method

</details>

*Assert conditions*

- Copy the DocumentationTests.cs file to the solution-documentation/api-get-method-summary/C#/*/ControllerTests folder
- Run tests in the DocumentationTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
