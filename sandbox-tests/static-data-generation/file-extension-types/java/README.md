**File extension types test**

*Test Description*
A developer is trying to generate the 10 most common file extensions

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project static-data-generation/file-extension-types/java
- Open the FileTypeRegistry class
- Add the suggested implementation to the FileTypeRegistry class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/file-extension-types/java in IDE
- Open the FileTypeRegistry class
- Type in the class:

```java
public final String[] top10FileExtensionTypesWithDot =
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/file-extension-types/java
- Open the FileTypeRegistry class
- Type in the chat window:

```
Create public top10FileExtensionTypesWithDot array with the top 10 file extension types
```

- Add the suggested implementation to the FileTypeRegistry class

</details>

*Assert conditions*

- Code must compile
- Copy the FileTypeRegistryTest class to the static-data-generation/file-extension-types/java/src/test/java/com/epam/aicode/java folder
- Run tests in FileTypeRegistryTest class. Tests must pass successfully
- The array must contain 10 types of file extensions

*Additional note*

The correct solutions is in the correctResponse.txt file