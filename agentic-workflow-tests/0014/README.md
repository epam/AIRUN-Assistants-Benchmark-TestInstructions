
# 0014. User Account Menu in Golf application


**Category:** solution-or-component-generation  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- HTML
- JavaScript

### Technologies

N/A


## Task

```md
Create an account menu for the Golf application pages. Add the following items to the account menu:
- logged user information including user name
- logout link
```

## Context

### Files

- `pom.xml`
- `src/main/resources/templates/home.html`
- `src/main/resources/templates/blocks/header.html`
- `src/main/resources/static/styles/main.css`
- `src/main/java/com/golf/app/controller/MainController.java`
- `src/main/java/com/golf/app/model/User.java`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run`
- Login to the application
- Verify that an account menu is added to navigation bar on all application pages
- Verify that the account menu is a drop-down menu and expands downwards
- Verify that an username is displayed in the account menu
- Verify that a logout element is added to the account menu
- Verify that an user is signed out after a click on the logout element
- Verify that an user is redirected to the proper login page after logout
- Add results of the manual tests to output.md. See (testing-template.md)[testing-template.md].

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure that dependency org.thymeleaf.extras:thymeleaf-extras-springsecurity6 is added to pom.xml
- **completeness** (==high==)
    - (==high==) Ensure that the HTML element of template containing the account menu includes the attribute defining the Thymeleaf security namespace
    - (==high==) Ensure that script bootstrap.bundle.min.js is imported on pages with account menu
    - (==high==) Ensure that div element with the attribute sec:authorize="isAuthenticated()" is added into nav element in the file containing the account menu
    - (==high==) Ensure that an element with the attribute sec:authentication="name" is added into authentication guarded element in the file containing the account menu
    - (==high==) Ensure that a logout element is added into authentication guarded element in the file containing the account menu
- **completeness** (==high==)
    - (==high==) Make sure that an account menu is added to navigation bar
    - (==high==) Make sure that the account menu expands downwards
    - (==high==) Make sure that an username is displayed in the account menu
    - (==high==) Make sure that a logout element is added to the account menu
    - (==high==) Make sure that an user is signed out after a click on the logout element
    - (==high==) Make sure that an user is redirected to the proper login page after logout
- **completeness** (==medium==)
    - (==high==) Make sure that the application is built without errors
    - (==high==) Make sure that the application is launched without errors
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

## Additional Notes

- See samples of correct solution in the [exemplar directory](exemplar).