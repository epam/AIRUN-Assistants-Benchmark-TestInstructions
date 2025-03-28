**Dockerfile code commenting test**

*Test Description*
A developer is trying to create comments for the Dockerfile file

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-explanation/dockerfile-comments
- Open the Dockerfile file
- Change the Dockerfile implementation to the suggested implementation

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-explanation/dockerfile-comments/java
- Open the Dockerfile file
- Highlight the Dockerfile file
- Type in the chat window:

```
Add detailed comments to the Dockerfile file definition
```

- Change the Dockerfile implementation to the suggested implementation

</details>

*Assert conditions*

Compare the generated comments with the comments in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file
