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
- Open the filelib.ts file
- Add the suggested function to the filelib.ts file

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/file-extension-types/java in IDE
- Open the filelib.ts file
- Type in the file:

```TypeScript
const top10FilesExtensionsWithDot: string[] = [
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/file-extension-types/java
- Open the filelib.ts file
- Type in the chat window:

```
Generate const top10FilesExtensionsWithDot: string[] = [
```

- Add the suggested function to the filelib.ts file

*Assert conditions*

- Copy the lib.test.ts file to the static-data-generation/file-extension-types/TypeScript/VSCode/src folder
- Install project dependencies. Run under VSCode folder:
npm install
- Run tests under VSCode folder:
npm test
- Code must compile
- Tests must pass successfully
- The array must contain 10 types of file extensions

*Additional note*

The correct solutions is in the correctResponse.txt file