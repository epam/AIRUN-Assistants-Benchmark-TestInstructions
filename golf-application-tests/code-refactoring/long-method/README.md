**Long method refactoring test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/utils/ScoreUtils.java
- Highlight 91-102 lines of code
- Open the chat AI interface and enter:

```
Extract a protected static setStableford(score, netScorePar) method and refactor it to use a switch block instead of an if
```

- Submit the question
- Add the suggested code to the ScoreUtils class
- Remove 91-102 lines of code
- Add on line 91:

```java
setStableford(score, netScorePar);
```

- Add all required imports

</details>

*Assert conditions*

- Copy the ScoreUtilsTest.java file to the src/test/java/com/golf/app/utils Golf application project folder
- Run the test in the ScoreUtilsTest class. The code should compile and the test should pass

*Additional note*

The correct solutions is in the correctResponse.txt file
