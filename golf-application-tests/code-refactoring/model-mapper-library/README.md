**Object mapping ModelMapper library test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/controller/CompetitionController.java
- Highlight  _ getCompetitionRounds(@PathVariable("id") Long id) _  and  _ convertToRoundDto _  methods
- Open the chat AI interface and enter:

> Refactor getCompetitionRounds method to apply ModelMapper

- Submit the question
- Replace the methods code with the suggested one
- Add all required imports

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/controller/CompetitionController.java
        - + fragment: getCompetitionRounds(@PathVariable("id") Long id) method
        - + fragment: convertToRoundDto method
org.modelmapper.ModelMapper
- Enter task description:

> Refactor getCompetitionRounds method to apply ModelMapper

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Copy the CompetitionControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run tests in the CompetitionControllerTest class. The code must compile and tests must pass

*Additional note*

The correct solutions is in the correctResponse.txt file
