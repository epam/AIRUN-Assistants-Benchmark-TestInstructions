**Largest even number bug-fixing test**

*Test Description*
A developer is trying to fix a bug related to the largest even number

*Act:*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-bugfixing/largest-even-number/java
- Open the FindLargestEvenNumber class
- Change the findLargestEvenNumber method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-bugfixing/largest-even-number/java
- Open the FindLargestEvenNumber class
- Highlight the findLargestEvenNumber method
- Type in the chat window:

```java
Fix a bug the in the findLargestEvenNumber(List numbers) method to not throw exception
```

- Change the findLargestEvenNumber method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the FindLargestEvenNumberTest.java file to the code-bugfixing/largest-even-number/java/src/test/java/com/epam/poc/aicode/java folder
- Run tests in the FindLargestEvenNumberTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file