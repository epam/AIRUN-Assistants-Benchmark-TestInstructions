** Repository and service generation test **

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/model/Marker.java
- Highlight the Marker class
- Open the chat AI interface and enter:

```
Create a Spring CRUD CrudRepository and a Spring service that uses this repository based on the Marker model. Apply java.util.Optional
```

- Submit the question
- Add the suggested repository code to class src/main/java/com/golf/app/repo/MarkerRepository.java
- Add the suggested service code to class src/main/java/com/golf/app/service/MarkerService.java
- Add all required imports

</details>

*Assert conditions*

- Copy the MarkerServiceTest.java file to the src/test/java/com/golf/app/service Golf application project folder
- Run tests in the MarkerServiceTest class. The code must compile and tests must pass

*Additional note*

One of the correct solutions can be found in the correctResponse.txt file

