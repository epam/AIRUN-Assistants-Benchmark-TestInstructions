**Database PreparedStatement test**

*Test Description*
A developer is trying to create a new method based on an existing one, using PreparedStatement instead of Statement, to improve the performance of retrieving data from a database

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-optimization/db-prepared-statement/java
- Open the DBUtils class
- Change the insertUsersIntoUserTable method to the suggested method

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project project code-optimization/db-prepared-statement/java in IDE
- Open the DBUtils class
- Type at the end of the class:

```java
// Implemented insertUsersIntoUserTable method applying PreparedStatement instead of Statement
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports
- Change the insertUsersIntoUserTable method to the suggested method

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-optimization/db-prepared-statement/java
- Open the DBUtils file
- Highlight the insertUsersIntoUserTable method
- Type in the chat window:

> Optimize the insertUsersIntoUserTable method to use PreparedStatement

- Change the insertUsersIntoUserTable method to the suggested method

</details>

*Assert conditions*

- Code must compile
- Copy the DBUtilsTest.java file to the code-optimization/db-prepared-statement/java/src/test/java folder
- Run tests in the DBUtilsTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file