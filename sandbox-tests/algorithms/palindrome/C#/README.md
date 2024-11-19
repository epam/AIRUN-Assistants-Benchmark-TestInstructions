**Palindrome number test**

*Test Description*
A developer is trying to create a method that checks whether a number is a palindrome

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/palindrome/C#
- Open the Lib class
- Add the suggested method to the Lib class
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/palindrome/C# in IDE
- Open the Lib class
- Type in the class:

```C#
// Implement a method to check whether a number is a palindrome
public static bool CheckIfNumberIsPalindrome(int n) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/palindrome/C#
- Open the Lib class
- Type in the chat window:

> Implement public static bool CheckIfNumberIsPalindrome(int n) method to check whether a number is a palindrome

- Add the suggested method to the Lib class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the LibTests.cs class to the algorithms/palindrome/C#/*/Test folder
- Run tests in the LibTests.cs class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file