**Unit test creation**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/utils/PlayerUtils.java
- Highlight the PlayerUtils class
- Open the chat AI interface and enter:

``` 
Implement the following tests for the capitalizeName method
- testCapitalizeName_singleWord
- testCapitalizeName_multipleWords
- testCapitalizeName_mixedCase
- testCapitalizeName_singleSpace

Implement the following tests for the calculateHandicapIndex method
- testCalculateHandicapIndex_validScore
- testCalculateHandicapIndex_nullScore
```

- Submit the question
- Add the suggested code to the src/test/java/com/golf/app/utils/PlayerUtilsTest.java class
- Add all required imports

</details>

*Assert conditions*

- Code must compile
- All required tests must be created
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that the tests are isolated and do not depend on each other
- Run tests in the PlayerUtilsTest class. Tests must pass successfully
- Run the command in the terminal:

```
mvn clean test jacoco:report
```

- Open the target/site/jacoco/index.html file. The coverage must exceed 70% for PlayerUtilsTest class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file