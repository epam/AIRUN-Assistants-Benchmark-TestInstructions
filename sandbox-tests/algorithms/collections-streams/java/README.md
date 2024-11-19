**Collections stream test**

*Test Description*
A developer is trying to generate a method using Stream API to sort prices in ASC and DESC order

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/collections-streams/java
- Open the EcommerceSorting class
- Change the priceSorting method to the suggested method
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/collections-streams/java in IDE
- Open the EcommerceSorting class
- Type at the end of the class:

```java
// Implemented the priceSortingUsingStreams method using Stream API 
public static Map<String, BigDecimal> priceSortingUsingStreams(Map<String, BigDecimal> products, String order) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports
- Remove the priceSorting method
- Change the name of the priceSortingUsingStreams method to priceSorting

</details>


<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/collections-streams/java
- Open the EcommerceSorting class
- Highlight the priceSorting method implementation
- Type in the chat window:

> Refactor the priceSorting method using the Stream API

- Change the priceSorting method to the suggested method
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the EcommerceSortingTest.java file to the algorithms/collections_streams/java/src/test/java folder
- Run tests in the EcommerceSortingTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file