**OpenAPI documentation generation test**

*Test Description*
A developer is trying to generate OpenAPI documentation for a controller

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project devops/openapi/C#
- Open the Controller class
- Add the suggested implementation to the GeneratedOpenApiDocumentation.json file

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project devops/openapi/C#
- Open the Controller class
- Highlight the class definition
- Type in the chat window:

```
Generate OpenAPI documentation for the Controller class in JSON format
```

- Add the suggested implementation to the GeneratedOpenApiDocumentation.json file

</details>

*Assert conditions*

- Copy the ControllerTests.cs and CorrectOpenApiDocumentation.json files to the devops/openapi/C#/VisualStudio/openapiTests folder
- Run tests in the ControllerTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file