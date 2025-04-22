**Object mapping ModelMapper library test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/controller/CompetitionController.java
- Highlight  _ getCompetitionRounds(@PathVariable("id") Long id) _  and  _ convertToRoundDto _  methods
- Open the chat AI interface and enter:

```
Refactor getCompetitionRounds method to apply ModelMapper
```

- Submit the question
- Replace the methods code with the suggested one
- Add all required imports

</details>

*Assert conditions*

- Copy the CompetitionControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run tests in the CompetitionControllerTest class. The code must compile and tests must pass

*Additional note*

The correct solutions is in the correctResponse.txt file
