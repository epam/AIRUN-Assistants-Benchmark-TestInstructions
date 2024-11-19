**CSV serialization test**

*Test Description*
A developer is trying to create a CSV serialization method

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/csv-serialization/TypeScript
- Open the csvService.ts file
- Add the suggested function to the csvService.ts file

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/csv-serialization/TypeScript in IDE
- Open the csvService.ts file
- Type in the file:

```TypeScript
export function serializeToCsv(data: any[], hasHeader: boolean = true, delimiter: string = ","): string
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/csv-serialization/TypeScript
- Open the csvService.ts file
- Type in the chat window:

```
Create the serializeToCsv(data: any[], hasHeader: boolean = true, delimiter: string = ","): string function
```

- Add the suggested function to the csvService.ts file

</details>

*Assert conditions*

- Copy the csvService.test.ts file to the solution-or-component-generation/csv-serialization/TypeScript/VSCode/src folder
- Install project dependencies. Run under VSCode folder:
npm install
- Run tests under VSCode folder:
npm test
- Code must compile
- Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
