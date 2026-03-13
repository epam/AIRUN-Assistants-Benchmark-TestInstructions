
# 0012. User Registration Fixup in Golf application


**Category:** code-refactoring  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

- Spring Security

## Task

```md
## Task

Fix up user registration in Golf application.

## Context

The application UI is protected with Spring Security.
The default Spring Security schema must be used to store users and roles.
The application must allow user registration with assigning ROLE_USER to newly created users.

## Issues

There some issues those should be fixed.

### User entity is incompatible with Spring Security

The entity class com.golf.app.model.User defined incorrectly and cannot be used to access USERS table.

### Unsupported Media Type error while registering users

The following error occurs while registering users:
"""
There was an unexpected error (type=Unsupported Media Type, status=415).
Content-Type 'application/x-www-form-urlencoded;charset=UTF-8' is not supported.
"""

### Unauthenticated users can not open user registration page

Unauthenticated users are redirected to login page once they visit the registration page.

### User password is entered as plain text on user registration page

Text input is used for password in user registration form.

## Instructions

- Refactor the entity class com.golf.app.model.User to be compatible with Spring Security default schema to access USERS table. The class must implements UserDetails, CredentialsContainer.
- Create com.golf.app.model.Role entity class to access AUTHORITIES table.
- Assign ROLE_USER to newly registered users.
- Fix Unsupported Media Type error.
- Secure password input in user registration form.
- Update security configuration to allow unauthenticated users to access registration page.
- Make sure to import all required classes in changed sources.
- Create a migration SQL script doing the following actions:
    - alter USERS table by adding column "email".
    - update existing users by setting email to value username@golf.com.
    - create an unique index on USERS table by "email" column.
```

## Context

### Files

- `src/main/java/com/golf/app/model/Role.java`
- `src/main/java/com/golf/app/model/User.java`
- `src/main/java/com/golf/app/controller/UserController.java`
- `src/main/java/com/golf/app/service/UserService.java`
- `src/main/java/com/golf/app/service/UserServiceImpl.java`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/resources/templates/registration/registration.html`
- `src/main/resources/db/migration/V11_0__schema.sql`
- `src/main/resources/db/migration/V11_1__data.sql`

## Arrangement

- Apply [the patch from 0011 test](../0011/exemplar/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch
```

        
- Optional: Delete unused src/main/resources/templates/registration.html file.

## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to make it compatible with your local environment
- Build the application with the command: `mvn clean install`
- Start the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.springframework.security=DEBUG"`
- Open the application [user registration page](http://localhost:8082/register)
- Register a new user
- Login with the new user credentials
- Add results of the registration test and login test to output.md

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that `User` class is annotated with `@Table(name = "users")`
    - (<mark>high</mark>) Ensure that `User` class implements `UserDetails`
    - (<mark>high</mark>) Ensure that `User` class implements `CredentialsContainer`
    - (<mark>high</mark>) Ensure that field `id` is removed from `User` class
    - (<mark>high</mark>) Ensure that field `username` is annotated `@id` in `User` class
    - (<mark>high</mark>) Ensure that field `password` has been made non-nullable in `User` class
    - (<mark>high</mark>) Ensure that unique non nullable string field `email` has been added to `User` class
    - (<mark>high</mark>) Ensure that non nullable boolean field `enabled` has been added to `User` class
    - (<mark>high</mark>) Ensure that `authorities` field has been added to `User` class
    - (<mark>high</mark>) Ensure that method `getAuthorities` has been overridden in `User` class
    - (<mark>high</mark>) Ensure that method `isAccountNonExpired` has been overridden in `User` class
    - (<mark>high</mark>) Ensure that method `isCredentialsNonExpired` has been overridden in `User` class
    - (<mark>high</mark>) Ensure that method `isEnabled` has been overridden in `User` class
    - (<mark>high</mark>) Ensure that overridden method `eraseCredentials` set `password` field to `null` in `User` class
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that `com.golf.app.model.Role` class is created
    - (<mark>high</mark>) Ensure that `Role` class is annotated with `@Table(name = "authorities")`
    - (<mark>high</mark>) Ensure that string field `username` has been added to `Role` class
    - (<mark>high</mark>) Ensure that field `username` annotated with `@Id` in `Role` class
    - (<mark>high</mark>) Ensure that string field `authority` has been added to `Role` class
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that `@RequestBody` annotation is removed from `user` parameter of `registerUser` method of `UserController` class
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that request matcher for `HttpMethod.POST` has been removed in `filterChain` method in `AppSecurityConfig` class
    - (<mark>high</mark>) Make sure that request matcher for `/register/**` path has been permitted in `filterChain` method in `AppSecurityConfig` class
    - (<mark>high</mark>) Make sure that request matcher for `/styles/**` path has been permitted in `filterChain` method in `AppSecurityConfig` class
    - (<mark>high</mark>) Make sure that request matcher for `/js/**` path has been permitted in `filterChain` method in `AppSecurityConfig` class
    - (<mark>high</mark>) Make sure that request matcher for `/images/**` path has been permitted in `filterChain` method in `AppSecurityConfig` class
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that `PasswordEncoder` field has been added to `UserServiceImpl` class
    - (<mark>high</mark>) Make sure that `registerUser` method is made transactional in `UserServiceImpl` class
    - (<mark>high</mark>) Make sure that `registerUser` method encodes user password before user saving in `UserServiceImpl` class
    - (<mark>high</mark>) Make sure that `registerUser` method assigns `ROLE_USER` to user before saving in `UserServiceImpl` class
    - (<mark>high</mark>) Make sure that `registerUser` method makes user enabled before saving in `UserServiceImpl` class
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that type of password input is changed to `password` in `src/main/resources/templates/registration/registration.html`
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that the created migration SQL script adds `email` column to `users` table
    - (<mark>high</mark>) Make sure that the created migration SQL script updates users `email` column value to concatenation of username and @golf.com
    - (<mark>high</mark>) Make sure that the created migration SQL script creates unique index users email
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that the migration SQL script(s) is executed on the application database without errors
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that the application is built without errors
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that the application is launched without errors
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that a new user can be registered
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that a new user can login after registration
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

- See [testing-template.md](testing-template.md) for example of extra report sections.
- See samples of correct solution in the [exemplar directory](exemplar).