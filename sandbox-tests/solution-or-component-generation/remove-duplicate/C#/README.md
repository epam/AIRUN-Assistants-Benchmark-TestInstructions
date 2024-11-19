**Remove duplication test**

*Test Description*

A developer is trying to create a method that removes duplicate items in the list

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/remove-duplicate/C#
- Open the CustomLinqExtenstions class
- Add the suggested method to the CustomLinqExtenstions class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/remove-duplicate/C# in IDE
- Open the CustomLinqExtenstions class
- Type in the class:

```C#
public static List<T> RemoveDuplicates<T>(this List<T> list) where T : IEquatable<T> {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/remove-duplicate/C#
- Open the CustomLinqExtenstions class
- Type in the chat window:

```
Implement the method to remove duplicate items in the list:
public static List RemoveDuplicates(this List list) where T : IEquatable{}
```

- Add the suggested method to the CustomLinqExtenstions class

</details>

*Assert conditions*

- Code must compile
- Copy the CustomLinqExtensionsTests class to the solution-or-component-generation/remove-duplicate/C#/VisualStudio/Test folder
- Run tests in the CustomLinqExtensionsTests class. Tests must pass successfully

*Additional note*

Examples of correct solutions are in the correctResponse.txt file.
