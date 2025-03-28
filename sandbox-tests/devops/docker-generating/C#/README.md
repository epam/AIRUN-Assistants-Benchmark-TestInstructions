**Dockerfile generation test**

*Test Description*
A developer tries to generate a Dockerfile for a console application

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project devops/docker-generating/C#

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project devops/docker-generating/C#
- Open the Dockerfile file
- Type in the file:

```
# Implemented Dockerfile for C# console application using SDK and runtime dotnet 6.0
```

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project devops/docker-generating/C#
- Open the Dockerfile file
- Type in the chat window:

```
Implement a Dockerfile for a console application using SDK and runtime dotnet 6.0
```

</details>

*Assert conditions*

Compare the generated implementation with the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file
