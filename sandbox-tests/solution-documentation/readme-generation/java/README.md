**README file generation test**

*Test Description*
A developer is trying to create a property description for a README file

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-documentation/readme-generation/java

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-documentation/readme-generation/java
- Open app.properties file
- Highlight the app.properties file
- Type in the chat window:

```
Generate a README.md file with properties and group them in a table using markdown syntax
```

</details>

*Assert conditions*

Compare the generated code with the reference_README.md file

*Additional note*

The correct solutions is in the reference_README.md file