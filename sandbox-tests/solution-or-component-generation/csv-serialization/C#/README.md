**CSV serialization test**

*Test Description*
A developer is trying to create a CSV serialization method

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/csv-serialization/C#
- Open the CsvService class
- Add the suggested method to the CsvService class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/csv-serialization/C# in IDE
- Open the CsvService class
- Type at the end of the class:

```C#
public static string SerializeToCsv<T>(IEnumerable<T> list, bool hasHeader = true, string delimiter = ",") where T : class
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add the suggested method to the CsvService class

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/csv-serialization/C#
- Open the CsvService class
- Type in the chat window:

```
Implement the following method:
public static string SerializeToCsv<T>(IEnumerable<T> list, bool hasHeader = true, string delimiter = ",") where T : class
```

- Add the suggested method to the CsvService class

</details>

*Assert conditions*

- Code must compile
- Copy the CsvServiceTests.cs file to the solution-or-component-generation/csv-serialization/C#/VisualStudio/Test folder
- Run tests in the CsvServiceTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
