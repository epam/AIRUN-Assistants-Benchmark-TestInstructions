**Collections parallel sorting test**

*Test Description*
A developer is trying to generate a method using a parallel sorting algorithm

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/collections-parallel-sorting/java
- Open the EcommerceSorting class
- Change the priceSorting method to the suggested method

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/collections-parallel-sorting/java in IDE
- Open the EcommerceSorting class
- Type at the end of the class:

```java
// Implemented method that uses a parallel stream
public static Map<String, BigDecimal> priceSortingParallelStream(Map<String, BigDecimal> products, String sortingType) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports
- Remove the priceSorting method
- Change the name of the priceSortingParallelStream method to priceSorting

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/collections-parallel-sorting/java
- Open the EcommerceSorting class
- Highlight the priceSorting method
- Type in the chat window:

> Implement the priceSorting method using a parallel stream

- Change the priceSorting method to the suggested method
  
</details>

*Assert conditions*

- Code must compile
- Copy the EcommerceSortingTest.java file to the algorithms/collections_parallel_sorting/java/src/test/java folder
- Run tests in the EcommerceSortingTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
