**JavaDoc comments test**

*Test Description*
A developer is trying to generate Javadoc comments for a class and a method

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-documentation/javadoc-comments/java
- Open the FileProcessor class
- Add the suggested implementation to the FileProcessor class

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-documentation/javadoc-comments/java
- Open the FileProcessor class
- Highlight the FileProcessor class
- Type in the chat window:

```
Implement Javadoc comments for the FileProcessor class and the processCsvToJson method
```

- Add the suggested implementation to the FileProcessor class

</details>

*Assert conditions*

- Compare the generated comments with the comments in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file
