**Sum of even numbers test**

*Test Description*
A developer is trying to fix a bug related to the sum of even number

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/sum-of-even-numbers/java
- Open the SumOfEvenNumbers class
- Change the sumOfEvenNumbers method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/sum-of-even-numbers/java
- Open the SumOfEvenNumbers class
- Highlight the sumOfEvenNumbers method
- Type in the chat window:

```
Implement the sumOfEvenNumbers method with a bug fix
```

- Change the sumOfEvenNumbers method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the SumOfEvenNumbersTest.java file to the code-bugfixing/sum-of-even-numbers/java/src/test/java/com/epam/poc/aicode/java folder
- Run tests in the SumOfEvenNumbersTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file