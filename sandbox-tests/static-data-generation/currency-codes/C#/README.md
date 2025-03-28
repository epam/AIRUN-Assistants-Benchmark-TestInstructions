**Currency codes generation test**

*Test Description*
A developer is trying to generate currency codes

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project static-data-generation/currency-codes/C#

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/currency-codes/C# in IDE
- Open the Program class
- Type in the class:

```C#
// Initialize list of 10 popular world currencies in ISO 4217 format
List<string> top10IsoCurrencyCodes = new List<string>() {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/currency-codes/C#
- Open the Program class
- Type in the chat window:

```
Create a list of 10 popular world currencies in ISO 4217 format without comments
```

</details>

*Assert conditions*

- 10 world currencies must be generated in ISO 4217 format
- Compare the generated currencies with the currencies in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file