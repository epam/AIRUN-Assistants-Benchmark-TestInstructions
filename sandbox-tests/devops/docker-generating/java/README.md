**Dockerfile generation test**

*Test Description*
A developer tries to generate a Dockerfile for a console application

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project devops/docker-generating/java

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project devops/docker-generating/java
- Open the Dockerfile file
- Type in the file:

```
# Implemented Dockerfile to build a docker image for a project using Java OpenJDK17
```

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project devops/docker-generating/java
- Open the Dockerfile file
- Type in the chat window:

> Generate a dockerfile using Java openjdk-17. The artifactId is "java", the version is "1.0.0-SNAPSHOT"

</details>

*Assert conditions*

Compare the generated implementation with the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file

