**Exception handling test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/controller/ExceptionHandlerController.java
- Highlight the ExceptionHandlerController class
- Open the chat AI interface and enter:

```
Create the class CourseNotFoundException with custom exception and add this exception to the ExceptionHandlerController and return value as ModelAndView
```

- Submit the question
- Add the suggested exception implementation to class src/main/java/com/golf/app/exception/CourseNotFoundException.java
- Add the suggested exception handling implementation to class src/main/java/com/golf/app/controller/ExceptionHandlerController.java
- Add all required imports

</details>

*Assert conditions*

- Copy the ExceptionHandlerControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run the test in the ExceptionHandlerControllerTest class. The code should compile and the test should pass

*Additional note*

The correct solutions is in the correctResponse.txt file
