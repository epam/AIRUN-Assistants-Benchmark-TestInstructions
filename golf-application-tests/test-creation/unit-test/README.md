**Unit test creation**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/utils/CourseUtils.java
- Highlight the CourseUtils class
- Open the chat AI interface and enter:

```
Create unit tests for the buildHoles method. To do this, create an object of the CourseDto class with all the necessary fields
```

- Submit the question
- Add the suggested code to the src/test/java/com/golf/app/utils/CourseUtilsTest.java class
- Add all required imports

</details>

*Assert conditions*

- Code must compile
- Tests must be created for all public methods of the class and focus on a single behavior or functionality
- Check the appropriate use of mocks and stubs to simulate dependencies
- Check that tests cover the main functionalities and edge cases of the class logic
- Run tests in the CourseUtilsTest class. Tests must pass successfully
- Run the command in the terminal:

```
mvn clean test jacoco:report
```

- Open the target/site/jacoco/index.html file. The coverage must exceed 70% for CourseUtilsTest class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file