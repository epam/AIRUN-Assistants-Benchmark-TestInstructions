
# 0011. Migrate in-memory user and role definitions to database in Golf application


**Category:** code-refactoring  
**Complexity:** low  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- SQL

### Technologies

N/A


## Task

```md
Migrate in-memory user and roles definitions to database.

Configure Spring Security to retrieve user information from the database.

Consider that default Spring Security schema should be used to store users and roles.
Ignore current user registration related model and functionality.

Create a migration SQL script to import existing in-memory users and roles to database.
```

## Context

### Files

- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/resources/application.properties`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- (Optional)
Copy [BCryptUsersPasswordSqlGenerator](BCryptUsersPasswordSqlGenerator.java) to golf-application/src/main/java.
Encode BCrypt-encoded user passwords by running BCryptUsersPasswordSqlGenerator.
Replace user passwords in generated migration SQL script with the encoded ones.

        
- Run the generated migration SQL script(s)
- Update database configuration in application.properties to match it with your local environment
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.springframework.security.web.context=DEBUG --logging.level.org.springframework.security.web.authentication=DEBUG"`
- Open the application at http://localhost:8082 and login with user `1` credentials
- Open the application at http://localhost:8082 and login with user `user` credentials
- Open the application at http://localhost:8082 and login with user `coach` credentials
- Open the application at http://localhost:8082 and login with user `a` credentials
- Add results of the manual tests to output.md. See [testing-template.md](testing-template.md).

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that the method declaring InMemoryUserDetailsManager bean has been removed from AppSecurityConfig.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that a bean implementing UserDetailsService is created and it obtains user details from database.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that a SQL script(s) to import existing in-memory users and roles to database is created.
    - (<mark>high</mark>) Ensure that the SQL script creates tables USERS and AUTHORITIES.
    - (<mark>high</mark>) Ensure that the SQL script creates an unique index for AUTHORITIES table for username, authority.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that the SQL script inserts user '1' into USERS table.
    - (<mark>high</mark>) Ensure that the SQL script inserts user 'user' into USERS table.
    - (<mark>high</mark>) Ensure that the SQL script inserts user 'coach' into USERS table.
    - (<mark>high</mark>) Ensure that the SQL script inserts user 'a' into USERS table.
    - (<mark>high</mark>) Ensure that the SQL script inserts 'user', 'ROLE_USER' into AUTHORITIES table.
    - (<mark>high</mark>) Ensure that the SQL script inserts '1', 'ROLE_USER' into AUTHORITIES table.
    - (<mark>high</mark>) Ensure that the SQL script inserts 'coach', 'ROLE_COACH' into AUTHORITIES table.
    - (<mark>high</mark>) Ensure that the SQL script inserts 'a', 'ROLE_ADMIN' into AUTHORITIES table.
- **completeness** (<mark>medium</mark>)
    - (<mark>high</mark>) Make sure that the application is built without errors
    - (<mark>high</mark>) Make sure that the application is launched without errors
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Assert that user '1' successfully did login with its credentials.
    - (<mark>high</mark>) Assert that user 'user' successfully logged in with its credentials.
    - (<mark>high</mark>) Assert that user 'coach' successfully logged in with its credentials.
    - (<mark>high</mark>) Assert that user 'a' successfully logged in with its credentials.
- **accuracy** (<mark>high</mark>): _functionality_
    - (<mark>high</mark>) Ensure that the CHANGED code accomplishes the intended functionality.
    - (<mark>high</mark>) Ensure that the CHANGED code handles potential edge cases, exceptions, or invalid inputs gracefully where it is required.
- **accuracy** (<mark>high</mark>): _adherence to task requirements_
    - (<mark>high</mark>) Make sure that the CHANGES are primarily made to achieve the intended functionality.
    - (<mark>high</mark>) Make sure that the CHANGES do not contain unrequested modifications, unused imports or code.
- **accuracy** (<mark>high</mark>): _code quality_
    - (<mark>high</mark>) Ensure that the CHANGED code is syntactically correct, compiles without errors.
    - (<mark>high</mark>) Ensure that the CHANGED code follows project style guides and maintain consistency with the existing codebase.
    - (<mark>high</mark>) Ensure that the CHANGED code is clean, readable, adheres to best practices and naming conventions.
    - (<mark>high</mark>) Ensure that the CHANGED code is easily maintainable, with proper structure and separation of concerns.
    - (<mark>high</mark>) Make sure that Spring Boot's features such as dependency injection, auto-configuration, and data access abstraction are properly utilized in the the CHANGED code.
- **accuracy** (<mark>high</mark>): _documentation_
    - (<mark>high</mark>) Ensure that the CHANGED code is well-documented, with clear and concise documentation for each part of the code.
- **accuracy** (<mark>high</mark>): _security_
    - (<mark>high</mark>) Ensure that CHANGED code keeps application secure by using proper authentication, authorization, and data validation techniques.
    - (<mark>high</mark>) Ensure that CHANGED code avoids exposing sensitive data.
    - (<mark>high</mark>) Ensure that CHANGED code protects the application from common security vulnerabilities.
- **accuracy** (<mark>high</mark>): _configuration_
    - (<mark>high</mark>) Ensure that CHANGED application configuration is flexible and externalized to efficiently manage different environments.

## Additional Notes

- See samples of correct solution in the [exemplar directory](exemplar).