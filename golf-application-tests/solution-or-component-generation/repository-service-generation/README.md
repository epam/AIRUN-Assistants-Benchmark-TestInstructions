** Repository and service generation test **

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/model/Marker.java
- Highlight the Marker class
- Open the chat AI interface and enter:

> Create a Spring CRUD CrudRepository and a Spring service that uses this repository based on the Marker model. Apply java.util.Optional

- Submit the question
- Add the suggested repository code to class src/main/java/com/golf/app/repo/MarkerRepository.java
- Add the suggested service code to class src/main/java/com/golf/app/service/MarkerService.java
- Add all required imports

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/main/java/com/golf/app/model/Marker.java
- Enter task description:

> Create a Spring CRUD CrudRepository and a Spring service that uses this repository based on the Marker model. Apply java.util.Optional

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Copy the MarkerServiceTest.java file to the src/test/java/com/golf/app/service Golf application project folder
- Run tests in the MarkerServiceTest class. The code must compile and tests must pass

*Additional note*

The correct solutions is in the correctResponse.txt file

