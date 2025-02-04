**0014. User Account Menu in Golf application**

*Act*

- Clone the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application
- Open the project in IDE
- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/resources/templates/home.html
    - src/main/resources/templates/blocks/header.html
    - src/main/resources/static/styles/main.css
    - src/main/java/com/golf/app/controller/MainController.java
    - src/main/java/com/golf/app/model/User.java
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
- Enter task description:

```markdown
Create an account menu for the application pages. Add the following items to the account menu:
- logged user info including user name
- logout link
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>
- Ensure that dependency org.thymeleaf.extras:thymeleaf-extras-springsecurity6 is added to pom.xml
- Ensure that following changes are added to src/main/resources/templates/blocks/header.html:
    - the attribute xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity6" is added to html element
    - div element with the attribute sec:authorize="isAuthenticated()" is added into nav element
    - an element with the attribute sec:authentication="name" is added into authentication guarded element
    - /logout link is added into is added into authentication guarded element
    - script element referencing bootstrap.bundle.min.js is added
- Make sure that the application is built without errors
- Make sure that the application is launched without errors
- Make sure that an account menu is added to navigation bar
- Make sure that an username is displayed in the account menu
- Make sure that a logout link is added to the account menu
- Make sure that an user is signed out after a click on the logout link
</details>

<details>
<summary>Automated LLM Assertion:</summary>
Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md) and extra steps described below.

Extra steps:
- Launch the application
- Login to the application
- Verify that an account menu is added to navigation bar on Main page, Players page, Round scores page, Competitions page, Courses page
- Verify that an username is displayed in the account menu
- Verify that a logout link is added to the account menu
- Verify that an user is signed out after a click on the logout link
- Add results of the manual tests to output.md. See (manual-testing-template.md)[manual-testing-template.md].

</details>

*Additional note*

See a sample of correct solution in the [0001-Fix-up-user-registration.patch](exemplar/0001-Fix-up-user-registration.patch).
