**Server side validation test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/controller/CourseController.java
- Highlight the addCourse method
- Open the chat AI interface and enter:

> Check for validation errors in the addCourse method using the BindingResult parameter and return the error page ("error/error-page") setting the errors in the model attribute

- Submit the question
- Update the addCourse method using the suggested code
- Add all required imports

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/controller/CourseController.java
        - + fragment: addCourse method
    - src/main/java/com/golf/app/dto/CourseDto.java
- Enter task description:

> There is CourseController class.
Check for validation errors in the addCourse method using the BindingResult parameter and return the error page ("error/error-page") setting the errors in the model attribute.

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Copy the CourseControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run the test in the CourseControllerTest class. The code should compile and the test should pass

*Additional note*

The correct solutions is in the correctResponse.txt file
