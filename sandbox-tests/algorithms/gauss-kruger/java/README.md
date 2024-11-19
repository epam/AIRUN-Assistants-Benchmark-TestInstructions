**Gauss Kruger algorithm test**

*Test Description*
A developer is trying to generate the method using the Gauss Kruger algorithm

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project algorithms/gauss-kruger/java
- Open the GaussKrugerEvaluator class
- Add the suggested method to the GaussKrugerEvaluator class
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project algorithms/gauss-kruger/java in IDE
- Open the GaussKrugerEvaluator class
- Type at the end of the class:

```java
public static double[] toGaussKruger(double latitude, double longitude) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project algorithms/gauss-kruger/java
- Open the GaussKrugerEvaluator class
- Type in the chat window:

> Implement public static double[] toGaussKruger(double latitude, double longitude) method that applies the Gauss Kruger algorithm

- Add the toGaussKruger method to the GaussKrugerEvaluator class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the GaussKrugerTest.java class to the algorithms/gauss-kruger/java/src/test/java folder
- Run the test in the GaussKrugerTest class. The test must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file