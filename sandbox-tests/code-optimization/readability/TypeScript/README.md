**Readability optimization test**

*Test Description*
A developer is trying to optimize code readability

*Act*:

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-optimization/readability/TypeScript
- Open the lib.ts file
- Change the calculateDiscount method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-optimization/readability/TypeScript
- Open the lib.ts file
- Highlight the calculateDiscount method
- Type in the chat window:

```
Optimize the calculateDiscount method to apply a switch statement instead of an if
```

- Change the calculateDiscount method to the suggested method

</details>

*Assert conditions*

- Copy the lib.test.ts file to the algorithms/factorial/TypeScript/VSCode/src folder
- Install project dependencies. Run under VSCode folder:
npm install
- Run tests under VSCode folder:
npm test
- Code must compile
- Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
