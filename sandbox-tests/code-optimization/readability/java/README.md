**Readability optimization test**

*Test Description*
A developer is trying to optimize code readability

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-optimization/readability/java
- Open the DiscountAction class
- Change the calculateDiscount method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-optimization/readability/java
- Open the DiscountAction class
- Highlight the calculateDiscount method
- Type in the chat window:

```
Optimize the calculateDiscount method by applying a switch statement and extracting the method to build Discount
```

- Change the calculateDiscount method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the DiscountActionTest.java file to the code-optimization/readability/java/src/test/java folder
- Run tests in the DiscountActionTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file