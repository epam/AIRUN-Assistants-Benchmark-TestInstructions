
# 0013. Verify User e-mail upon Registration in Golf application


**Category:** solution-or-component-generation  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

- Spring Security
- e-mail

## Task

```md
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

## Context

### Files

- `pom.xml`
- `src/main/resources/application.properties`
- `src/main/java/com/golf/app/model/Role.java`
- `src/main/java/com/golf/app/model/User.java`
- `src/main/java/com/golf/app/controller/UserController.java`
- `src/main/java/com/golf/app/service/UserService.java`
- `src/main/java/com/golf/app/service/UserServiceImpl.java`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/resources/templates/registration/registration.html`

## Arrangement

- Apply [the patch from 0011 test](../0011/exemplar/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch
```

        
- Apply [the patch from 0012 test](../0012/exemplar/0001-Fix-up-user-registration.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0012/exemplar/0001-Fix-up-user-registration.patch
```

        
- Start MailHog docker container:

```bash
docker run -p 8025:8025 -p 1025:1025 mailhog/mailhog
```

        

## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to make it compatible with your local environment
- Update email configuration in application.properties to make it compatible with your local environment
- Run database migration scripts
- Build the application with the command: `mvn clean install`
- Start the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments=--spring.jpa.hibernate.ddl-auto=validate`
- Open the application [user registration page](http://localhost:8082/register)
- Register a first user
- Visit [MailHog UI](http://localhost:8025/)
- Look for the user registration email in Inbox
- Visit the user email address verification link found in the email
- Login with the first user credentials
- Register a second user
- Try to login with the second user credentials
- Wait 5 minutes and look for the user email registration email in MailHog Inbox
- Try to visit the user email address verification link found in the email
- Add results of the registration test and login test to output.md

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure that org.springframework.boot:spring-boot-starter-mail dependency has been added added to `pom.xml`
- **completeness** (==high==)
    - (==high==) Ensure that spring mail has been configured in `src/main/resources/application.properties`
- **completeness** (==high==)
    - (==high==) Make user that registration confirmation template has been created
- **completeness** (==high==)
    - (==high==) Make user that registration verification template has been created
- **completeness** (==high==)
    - (==high==) Make sure that `UserController.registerUser` method returns registration confirmation view name
    - (==high==) Make sure that `verifyEmail` method parameterized by token is added to `UserController` class
    - (==high==) Make sure that `UserController.verifyEmail` method is annotated with `@GetMapping`
    - (==high==) Make sure that `UserController.verifyEmail` method verifies token via `userService` method call
    - (==high==) Make sure that `UserController.verifyEmail` method returns registration verification view name
- **completeness** (==high==)
    - (==high==) Make sure that `UserServiceImpl.registerUser` creates a not enabled user
    - (==high==) Make sure that `UserServiceImpl.registerUser` creates an user email verification token
    - (==high==) Make sure that `verifyEmail` method is added to `UserServiceImpl` class
    - (==high==) Make sure that `UserServiceImpl.verifyEmail` method enables an user if a non-expired user email verification token exists
- **completeness** (==high==)
    - (==high==) Make sure that the application sends an email to the address specified by a registered user and includes an user email verification link
- **completeness** (==high==)
    - (==high==) Make sure that the application is built without errors
- **completeness** (==high==)
    - (==high==) Make sure that the application is launched without errors
- **completeness** (==high==)
    - (==high==) Make sure that an user can be registered in the application
    - (==high==) Make sure that the registered user cannot log in to the application until the email address is verified
    - (==high==) Make sure that the registered user can log in to the application after verifying the email address
- **completeness** (==high==)
    - (==high==) Make sure the application sends an email about the user's registration to the provided address
    - (==high==) Make sure the user registration email contains email verification link
- **completeness** (==high==)
    - (==high==) Make sure the non-expired user email verification link can be successfully opened
    - (==high==) Make sure the expired email verification link opened unsuccessfully
- **accuracy** (==high==): __functionality__
    - (==high==) Ensure that the CHANGED code accomplishes the intended functionality.
    - (==high==) Ensure that the CHANGED code handles potential edge cases, exceptions, or invalid inputs gracefully where it is required.
- **accuracy** (==high==): __adherence to task requirements__
    - (==high==) Make sure that the CHANGES are primarily made to achieve the intended functionality.
    - (==high==) Make sure that the CHANGES do not contain unrequested modifications, unused imports or code.
- **accuracy** (==high==): __code quality__
    - (==high==) Ensure that the CHANGED code is syntactically correct, compiles without errors.
    - (==high==) Ensure that the CHANGED code follows project style guides and maintain consistency with the existing codebase.
    - (==high==) Ensure that the CHANGED code is clean, readable, adheres to best practices and naming conventions.
    - (==high==) Ensure that the CHANGED code is easily maintainable, with proper structure and separation of concerns.
    - (==high==) Make sure that Spring Boot's features such as dependency injection, auto-configuration, and data access abstraction are properly utilized in the the CHANGED code.
- **accuracy** (==high==): __documentation__
    - (==high==) Ensure that the CHANGED code is well-documented, with clear and concise documentation for each part of the code.
- **accuracy** (==high==): __security__
    - (==high==) Ensure that CHANGED code keeps application secure by using proper authentication, authorization, and data validation techniques.
    - (==high==) Ensure that CHANGED code avoids exposing sensitive data.
    - (==high==) Ensure that CHANGED code protects the application from common security vulnerabilities.
- **accuracy** (==high==): __configuration__
    - (==high==) Ensure that CHANGED application configuration is flexible and externalized to efficiently manage different environments.
- **accuracy** (==high==): __reliability and fault tolerance__
    - (==high==) Ensure that application sends an user registration email after committing of user registration transaction
    - (==high==) Ensure that application sends an user registration email asynchronously

## Additional Notes

- See [testing-template.md](testing-template.md) for example of extra report sections.
- See samples of correct solution in the [exemplar directory](exemplar).