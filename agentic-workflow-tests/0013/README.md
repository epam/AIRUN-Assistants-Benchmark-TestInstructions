**0013. Verify User e-mail upon Registration in Golf application**

*Act*

- Clone the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application
- Apply [the patch from 0011 test](../0011/exemplar/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0011/exemplar//0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch
```

- Apply [the patch from 0012 test](../0012/exemplar/0001-Fix-up-user-registration.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0012/exemplar/0001-Fix-up-user-registration.patch
```

- Open the project in IDE
- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - pom.xml
    - src/main/java/com/golf/app/model/User.java
    - src/main/java/com/golf/app/controller/UserController.java
    - src/main/java/com/golf/app/service/UserService.java
    - src/main/java/com/golf/app/service/UserServiceImpl.java
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
    - src/main/resources/application.properties
    - src/main/resources/templates/registration/registration.html
- Enter task description:

```markdown
## Task

Finish user registration process by verifying the user’s email to enable the user’s account

## Context

The application UI is protected with Spring Security.
The default Spring Security schema is used to store users and roles.
An user enters his e-mail address during registration.

## Instructions

- Make an user account to be disabled just after registration.
- Send a confirmation email message to an user entered e-mail address with link pointing to the application e-mail verification endpoint.
- Make the e-mail address verification link expires within a configured period, 5 minutes by default.
- Enable the user account after the verification link is visited.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Testing*

- Start MailHog docker container:

```bash
docker run -p 8025:8025 -p 1025:1025 mailhog/mailhog
```

- Update database configuration in application.properties to make it compatible with your local environment
- Update email configuration in application.properties to make it compatible with your local environment
- Build the application with the command: `mvn clean install`
- Start the application with the command: `mvn spring-boot:run`
- Open application UI at http://localhost:8082/register
- Register a first user
- Visit MailHog UI at http://localhost:8025/
- Look for the user registration email in Inbox
- Visit the user email address verification link found in the email
- Login with the user credentials
- Register a second user
- Try to login with the user credentials
- Wait 5 minutes and look for the user email registration email in MailHog Inbox
- Try to visit the user email address verification link found in the email

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Ensure that spring-boot-starter-mail dependency is added to `pom.xml`
- Ensure that spring mail is configured in `src/main/resources/application.properties``, for instance:

```properties
spring.mail.host=${GOLF_APP_MAIL_HOST:smtp.gmail.com}
spring.mail.port=${GOLF_APP_MAIL_PORT:587}
spring.mail.username=${GOLF_APP_MAIL_USERNAME}
spring.mail.password=${GOLF_APP_MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
- Make user that registration confirmation template is created, for instance `src/main/resources/templates/registration/confirmation.html`
- Make user that registration verification template is created, for instance `src/main/resources/templates/registration/verification.html`
- Make sure that UserController registerUser method returns registration confirmation view name, for instance "registration/confirmation"
- Make sure that verifyEmail method parameterized by token is added to UserController class
- Make sure that UserController verifyEmail method is annotated with @GetMapping
- Make sure that UserController verifyEmail method verify token via userService method call
- Make sure that UserController verifyEmail method returns registration verification view name, for instance "registration/verification"
- Make sure that UserServiceImpl creates a not enabled user in registerUser method
- Make sure that UserServiceImpl creates an user email verification token in registerUser method
- Make sure that verifyEmail method is added to UserServiceImpl class
- Make sure that UserServiceImpl verifyEmail method enables an user if a non-expired user email verification token exists
- Make sure that the application sends an email to an address specified by a registered user and includes an user email verification link
- Make sure that the application is built without errors
- Make sure that the application is launched without errors
- Make sure that a new user can be registered
- Make sure that a new user receives an email with email verification link
- Make user that a new user can login if he has visited the email verification link
- Make user that a new user cannot login if he has not visited the email verification link
</details>

<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md) and extra steps described below.

The following manual steps are required before running the evaluation (see [template](../auto-llm-eval/manual-output-include-template.md) ):
- Add output of `mvn clean install` to output.md.
- Add output of `mvn spring-boot:run` to output.md.
- Add manual test results to output.md. See [manual-testing-template.md](manual-testing-template.md).

</details>

*Additional note*

See a sample of correct solution in the [TODO.patch](exemplar/TODO.patch).