**Security configuration test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to class src/main/java/com/golf/app/security/AppSecurityConfig.java
- Highlight the filterChain method
- Open the chat AI interface and enter:

```
Refactor the filterChain method to allow anonymous access on /login and restrict /admin to ADMIN roles
```

- Submit the question
- Replace the filterChain method with the suggested method
- Add all required imports

</details>

*Assert conditions*

- Copy the AppSecurityConfigTest.java file to the src/test/java/com/golf/app/security Golf application project folder
- Run tests in the AppSecurityConfigTest class. The code must and tests must pass

*Additional note*

The correct solutions is in the correctResponse.txt file
