**Database migration test**

*Test Description*
A developer is trying to migrate data from one database to another

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-migration/database-migration/java
- Open the DBUtils class
- Add the suggested method to the DBUtils class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-migration/database-migration/java in IDE
- Open the DBUtils class
- Type at the end of the class:

```java
// Implemented method for migrating user data from one database to another that has the following parameters:
// the source database connection and target database connection
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/database-migration/java
- Open the DBUtils class
- Highlight the DBUtils class
- Type in the chat window:

> Implement a method for migrating user data from one database to another that has the following parameters:
the source database connection and target database connection

- Add the suggested method to the DBUtils class

</details>

*Assert conditions*

- Code must compile
- Copy the DBUtilsTest.java file to the solution-migration/database-migration/java/src/test/java folder
- Add the suggested method to line 35 of the DBUtilsTest class
- Run tests in the DBUtilsTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
