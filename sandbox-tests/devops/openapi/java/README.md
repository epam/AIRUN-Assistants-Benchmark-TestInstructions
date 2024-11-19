**OpenAPI documentation generation test**

*Test Description*
A developer is trying to generate OpenAPI documentation for a controller

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project devops/openapi/java
- Open the Controller class
- Add the suggested implementation to the generatedOpenApi.json file

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project devops/openapi/java
- Open the Controller class 
- Highlight the Controller class
- Type in the chat window:

> Implement OpenAPI v3 controller definition in JSON

- Add the suggested implementation to the generatedOpenApi.json file

</details>

*Assert conditions*

- Copy the OpenApiIntegrationTest.java file to the devops/openapi/java/src/test/java/com/epam/poc/aicode/devops/openapi folder
- Copy the users-schema.json file to the devops/openapi/java/src/test/resources folder
- Run tests in the OpenApiIntegrationTest class. Tests must pass successfully