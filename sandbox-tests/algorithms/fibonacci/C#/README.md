**Fibonacci test**

*Test Description*
A developer is trying to create a method that calculates Fibonacci numbers.

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/fibonacci/C#
- Open the Lib class
- Add the suggested method to the Lib class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/fibonacci/C# in IDE
- Open the Lib class
- In the class, Type:

```C#
public static int Fibonacci(int n) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/fibonacci/C#
- Open the Lib class
- Type in the chat window:

```C#
Implement public static int Fibonacci(int n) method that takes integer and produces a Fibonacci value for this number
```

- Add the suggested method to the Lib class

</details>

*Assert conditions*

- Code must compile
- Copy the LibTests.cs file to the algorithms/fibonacci/C#/*/Test folder
- Run tests in the LibTests.cs class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file