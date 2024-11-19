**Factorial test**

*Test Description*
A developer is trying to create a method that calculates the factorial of numbers

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/factorial/C#
- Open the Lib class
- Add the suggested method implementation to the Lib class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/factorial/C# in IDE
- Open the Lib class 
- Type in the class:

```C#
public static int CalculateFactorialOfNumber(int n) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/factorial/C#
- Open the Lib class 
- Type in the chat window:

> Implement the following method: public static int CalculateFactorialOfNumber(int n)

- Add the suggested method implementation to the Lib class

</details>

*Assert conditions*

- Code must compile
- Copy the LibTests.cs file to the algorithms/factorial/C#/VisualStudio/Test folder
- Run tests in the LibTests.cs class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file