**Javadoc generation test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to file src/main/java/com/golf/app/controller/CompetitionController.java
- Highlight the CompetitionController class
- Open the chat AI interface and enter:

> Add comments to the CompetitionController based on the Javadoc standard

- Submit the question

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/controller/CompetitionController.java
- Enter task description:

> Add comments to the CompetitionController based on the Javadoc standard

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Javadoc comments should be added to the CompetitionController class at least for class and methods declaration

*Additional note*

The correct solutions is in the correctResponse.txt file
