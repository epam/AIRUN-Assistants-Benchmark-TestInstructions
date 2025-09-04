**UserDetailsImpl class generation test**

*Test Description*
A developer is trying to generate a UserDetailsImpl class that implements the UserDetails interface from Spring Security

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/user-details/java
- Open the UserDetailsImpl class
- Add the suggested implementation to the UserDetailsImpl class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/user-details/java
- Open the User class
- Open the EUserRole class
- Open the User class
- Open the UserRole class
- Open the UserStatus class
- Open the UserDetailsImpl class
- Type in the chat window:

```
Generate the following UserDetailsImpl class implementation:
- UserDetailsImpl must implement the UserDetails interface from org.springframework.security
- UserDetailsImpl must wrap an existing User class object
```

- Add the suggested implementation to the UserDetailsImpl class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the UserDetailsImplTest class to the solution-or-component-generation/user-details/java/src/test/java/com/epam/aicode folder
- Run tests in the UserDetailsImplTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file
