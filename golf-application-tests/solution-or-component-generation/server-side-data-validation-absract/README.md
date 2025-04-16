**Server side validation test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Open the class src/main/java/com/golf/app/dto/CourseDto.java
- Go to class src/main/java/com/golf/app/controller/CourseController.java
- Highlight the addCourse method
- Open the chat AI interface and enter:

```
Check for validation errors in the addCourse method for CourseDto parameter and return the error page ("error/error-page") with validation errors
```

- Submit the question
- Update the addCourse method using the suggested code
- Add all required imports

</details>

*Assert conditions*

- Copy the CourseControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run the test in the CourseControllerTest class. The code should compile and the test should pass

*Additional note*

The correct solutions is in the correctResponse.txt file
