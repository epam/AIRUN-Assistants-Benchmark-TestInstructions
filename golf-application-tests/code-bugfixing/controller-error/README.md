**Controller error fixing test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Open class src/main/java/com/golf/app/controller/UserController.java
- Highlight the  _ registerUser _  method
- Open the chat AI interface and enter:

```
Resolve the error that occurs when calling the registerUser method:
Content-Type 'application/x-www-form-urlencoded;charset=UTF-8' is not supported. org.springframework.web.HttpMediaTypeNotSupportedException: Content-Type 'application/x-www-form-urlencoded;charset=UTF-8' is not supported
```

- Submit the question 
- Replace the registerUser method code with the suggested code
- Add all required imports

</details>

*Assert conditions*

- Copy the UserControllerTest.java file to the src/test/java/com/golf/app/controller Golf application project folder
- Run tests in the UserControllerTest class. The code must compile and tests must pass

*Additional note*

The correct solutions is in the correctResponse.txt file
