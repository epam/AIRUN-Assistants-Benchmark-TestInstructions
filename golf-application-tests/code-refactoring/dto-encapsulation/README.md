**DTO encapsulation test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Open the RoundScoreDto class
- Go to class src/main/java/com/golf/app/controller/RoundScoreController.java
- Highlight the displayScoreCardInputPage method
- Open the chat AI interface and enter:

```
Set all the data from the model attributes in the displayScoreCardInputPage method to a RoundScoreDto object and pass only that object as a single attribute named "roundScoreDto"
```

- Submit the question
- Replace the displayScoreCardInputPage method code with the suggested code
- Add all required imports

</details>

*Assert conditions*

- Copy the RoundScoreControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run the test in the RoundScoreControllerTest class. The code should compile and the test should pass

*Additional note*

The correct solutions is in the correctResponse.txt file
