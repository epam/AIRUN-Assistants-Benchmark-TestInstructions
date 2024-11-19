**Remove duplication test**

*Test Description*
A developer is trying to create a method that removes duplicate items in the list

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/remove-duplicate/TypeScript
- Open the lib.ts file
- Add the suggested function to the lib.ts file

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/remove-duplicate/TypeScript in IDE
- Open the lib.ts file
- Type in the file:

```TypeScript
export function removeDuplicates<T>(array: T[]): T[]
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/remove-duplicate/TypeScript
- Open the lib.ts file
- Type in the chat window:

```
Create the removeDuplicates<T>(array: T[]): T[]) function
```

- Add the suggested function to the lib.ts file

</details>

*Assert conditions*

- Copy the lib.test.ts file to the solution-or-component-generation/remove-duplicate/TypeScript/VSCode/src folder
- Install project dependencies. Run under VSCode folder:
npm install
- Run tests under VSCode folder:
npm test
- Code must compile
- Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file