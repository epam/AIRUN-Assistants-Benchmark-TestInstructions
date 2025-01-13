**Migrate to REST controller test**

*Test Description*
A developer is trying to migrate a controller to a REST controller for handling calls from the frontend service.

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-migration/rest-controller/java
- Open the PlayerController class
- Change the PlayerController implementation to the suggested implementation
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-migration/rest-controller/java
- Open the PlayerController class
- Type at the end of the class:

```java
// Rewrite the PlayerController as a REST controller that responds with JSON data using Spring Web
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys 
- Change the PlayerController implementation to the suggested implementation

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/rest-controller/java
- Open the PlayerController class
- Type in the chat window:

> Rewrite the PlayerController as a REST controller that responds with JSON data using Spring Web

- Change the PlayerController implementation to the suggested implementation
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the PlayerControllerTest.java file to the solution-migration/rest-controller/java/src/test/java folder
- Run tests in the PlayerControllerTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file