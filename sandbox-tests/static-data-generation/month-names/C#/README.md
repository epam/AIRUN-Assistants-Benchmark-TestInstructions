**Month names generation test**

*Test Description*
A developer is trying to generate month names

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project static-data-generation/month-names/C#

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/month-names/C# in IDE
- Open the Program class
- Type in the class:

```C#
string[] englishMonthNames = new string[] {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/month-names/C#
- Open the Program class
- Type in the chat window:

```
Create an array with the names of the months in English
```

</details>

*Assert conditions*

- Code must compile
- 12 month names must be generated

*Additional note*

The correct solutions is in the correctResponse.txt file