**Refactoring constants in alphabetical order test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/utils/AppConstant.java
- Highlight the constants
- Open the chat AI interface and enter:

```
Sort the constants alphabetically, treating the underscore `_` as a separator that implies a new word starting.
Primary sort is by the first word. If the first word is identical, sort by the next word after the underscore
```

- Submit the question
- Add the suggested code to the AppConstant class

</details>

*Assert conditions*

- Copy the AppConstantTest.java file to the src/test/java/com/golf/app/utils Golf application project folder
- Run the test in the AppConstantTest class. The code should compile and the test should pass

*Additional note*
The correct solutions is in the correctResponse.txt file
