**Unit test generation with mock test**

*Test Description*:
A developer is trying to generate unit test using mocks

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project tests-creation/unit-test-mock/C#
- Open the RefferalProgram.cs class
- Add suggested tests to the Tests.cs class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project tests-creation/unit-test-mock/C#
- Open the RefferalProgram class
- Highlight the CalculateReferralBonus method
- Type in the chat window:

> Cover the CalculateReferralBonus method with 5 unit tests, using C#, NUnit and NSubstitute

- Add suggested tests to the Tests.cs class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Run tests in the Tests class. Tests must pass successfully
- Run the command in the terminal:

```
dotnet test /p:CollectCoverage=true /p:CoverletOutputFormat=cobertura
```

- Check the test coverage at the terminal output. The coverage must exceed 70% for Tests class methods

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file