**Database performance issue test**

*Test Description*
A developer is trying to improve the performance of data retrieval by filtering orders directly in the database before retrieving them

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-optimization/db-performance-issue/C#
- Open the OrdersRepository class
- Add the suggested method implementation to the OrdersRepository class

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project code-optimization/db-performance-issue/C# in IDE
- Open the OrdersRepository class
- Type at the end of the class:

```C#
// Implemented above method, but optimized and named GetAllNonCompletedOrdersOptimized
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-optimization/db-performance-issue/C#
- Open the OrdersRepository file
- Highlight the GetAllNonCompletedOrdersNonOptimized method
- Type in the chat window:

> Optimize the GetAllNonCompletedOrdersNonOptimized method and named it GetAllNonCompletedOrdersOptimized 

- Add the suggested method implementation to the OrdersRepository class

</details>

*Assert conditions*

- Code must compile
- Copy the OrderRepositoryPerformanceTests.cs file to the code-optimization/db-performance-issue/C#/*/Test folder
- Run tests in the OrderRepositoryPerformanceTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
