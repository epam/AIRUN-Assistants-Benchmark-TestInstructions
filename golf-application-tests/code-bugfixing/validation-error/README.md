**Validation error fixing test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/utils/ValidationUtils.java
- Highlight the  _ getFieldErrors _  method
- Open the chat AI interface and enter:

> Resolve the error in the getFieldErrors method during validation of the player object:
java.lang.IllegalStateException: Duplicate key surname (attempted merging values Surname should not be empty and Surname should be between 3 and 50 characters)

- Submit the question 
- Replace the method code with the suggested code
- Add all required imports

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/utils/ValidationUtils.java
        - + fragment: getFieldErrors method
    - src/main/java/com/golf/app/model/Player.java
    - src/main/java/com/golf/app/model/Round.java
- Enter task description:

> There is ValidationUtils class.
Resolve the error in the getFieldErrors method during validation of the player object:
"java.lang.IllegalStateException: Duplicate key surname (attempted merging values Surname should not be empty and Surname should be between 3 and 50 characters)".

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Copy the ValidationUtilsTest.java file to the src/test/java/com/golf/app/utils Golf application project folder
- Run the test in the ValidationUtilsTest class. The code must compile and the test must pass

*Additional note*

The correct solutions is in the correctResponse.txt file
