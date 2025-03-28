**Largest even number bug-fixing test**

*Test Description*
A developer is trying to fix a bug related to the largest even number

*Act:*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/largest-even-number/C#
- Open the FindLargestEvenNumber class
- Change the FindLargestEvenNumber method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/largest-even-number/C#
- Open the FindLargestEvenNumber class
- Highlight the FindLargestEvenNumber method
- Type in the chat window:

```C#
Fix a bug in the FindLargestEvenNumber method to not throw an exception if the list of numbers does not contain even numbers
```

- Change the FindLargestEvenNumber method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the NumberHelperTests.cs file to the code-bugfixing/largest-even-number/C#/*/largestEvenNumberTests folder
- Run tests in the NumberHelperTests class. Tests must pass successfully