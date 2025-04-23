**MIME types generation test**

*Test Description*
A developer is trying to generate MIME types

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project static-data-generation/mime-types/java

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/mime-types/java in IDE
- Open the HttpResponseParser class
- Type in the class:

```java
private String[] MIME_TYPES = {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/mime-types/java
- Open the HttpResponseParser class
- Type in the chat window:

```
Create an array with MIME types
```

</details>

*Assert conditions*

- Code must compile
- MIME types must be generated

*Additional note*

The correct solutions is in the correctResponse.txt file