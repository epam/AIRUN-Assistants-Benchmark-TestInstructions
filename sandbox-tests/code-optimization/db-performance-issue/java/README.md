**Database performance issue test**

*Test Description*
A developer is trying to improve the performance of data retrieval by creating an index

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-optimization/db-performance-issue/java

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the DBUtils class
- Type at the end of the class:

```java
public static void createIndex(Statement statement) throws SQLException {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-optimization/db-performance-issue/java
- Open the DBUtils class
- Highlight the DBUtils class
- Type in the chat window:

> Implement the createIndex(Statement statement) method to create an index on the name column in the Employee table

</details>

*Assert conditions*

Compare the generated method with the method in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file