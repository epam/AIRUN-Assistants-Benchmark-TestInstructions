**Sum of even numbers test**

*Test Description*
A developer is trying to fix a bug related to the sum of even number

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/sum-of-even-numbers/C#
- Open the NumericHelper class
- Change the SumOfEvenNumbers method to the suggested method
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/sum-of-even-numbers/C#
- Open the NumericHelper class
- Highlight the SumOfEvenNumbers method
- Type in the chat window:

> Implement the SumOfEvenNumbers method with a bug fix

- Change the SumOfEvenNumbers method to the suggested method
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the NumericHelperTests.cs file to the code-bugfixing/sum-of-even-numbers/C#/*/sumOfEvenNumbersTests folder
- Run tests in the NumericHelperTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file