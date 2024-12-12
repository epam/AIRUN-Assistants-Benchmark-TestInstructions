**Unit test generation for a functional interface**

*Test Description*:

A developer is trying to generate unit tests for a functional interface

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project tests-creation/func-interface/java
- Open the BigDecimalTransformer class and scroll it from top till bottom
- Open the BigDecimalUtils class and scroll it from top till bottom
- Open the BigDecimalUtilsTest class
- Type `@Test` in the class body and press Enter
- Accept the best suggestion using the TAB and ENTER keys
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- The test must be generated
- Build the project and run the test with the command `gradle clean build` and verify no errors reported
- Open  _ build/reports/jacoco/test/html/index.html _  in browser and verify the code coverage is 100%

*Additional note*

Examples of the possible solutions are in the correctResponse1.txt and correctResponse2.txt files
