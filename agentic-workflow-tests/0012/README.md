**0012. User Registration Fixup in Golf application**

*Act*

- Clone the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application
- Apply [the patch from 0011 test](../0011/exemplar/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch) to prepare project codebase for test:

```bash
git am < path_to_patch/0001-Migrate-in-memory-user-and-roles-definitions-to-data.patch
```
- Delete src/main/resources/templates/registration.html file
- Open the project in IDE
- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/java/com/golf/app/model/Role.java
    - src/main/java/com/golf/app/model/User.java
    - src/main/java/com/golf/app/controller/UserController.java
    - src/main/java/com/golf/app/service/UserService.java
    - src/main/java/com/golf/app/service/UserServiceImpl.java
    - src/main/java/com/golf/app/security/AppSecurityConfig.java
    - src/main/resources/templates/registration/registration.html
    - src/main/resources/db/migration/V11_0__schema.sql
    - src/main/resources/db/migration/V11_1__data.sql
- Enter task description:

```markdown
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

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Make sure, the following changes suggested in src/main/java/com/golf/app/model/User.java:
    - the class is annotated with @Table(name = "users")
    - the class implements UserDetails, CredentialsContainer
    - field id is removed
    - field username is annotated @id
    - field password has made not nullable
    - added unique non nullable string field email
    - added non nullable boolean field enabled
    - added authorities field
    - overridden method getAuthorities
    - overridden method isAccountNonExpired
    - overridden method isCredentialsNonExpired
    - overridden method isEnabled
    - overridden method eraseCredentials set password field to null
- Make sure, src/main/java/com/golf/app/model/Role.java is created and it has the following changes:
    - the class is annotated with @Table(name = "authorities")
    - string field username is added
    - field username annotated with @Id
    - string field authority is added
- Make sure that @RequestBody annotation is removed from user parameter of registerUser method of UserController class
- Make sure, the following changes suggested in filterChain method in src/main/java/com/golf/app/security/AppSecurityConfig.java:
    - removed request matcher for HttpMethod.POST
    - permitted request matcher for "/register/**" path
    - permitted request matcher for "/styles/**" path
    - permitted request matcher for "/js/**" path
    - permitted request matcher for "/images/**" path
- Make sure, the following changes suggested in src/main/java/com/golf/app/service/UserServiceImpl.java
    - PasswordEncoder field added to the class
    - registerUser method is made transactional
    - registerUser method encodes user password before user saving
    - registerUser method assigns ROLE_USER to user before saving
    - registerUser method makes user enabled before saving
- Make sure that type of password input is changed to password in src/main/resources/templates/registration/registration.html
- Make sure that a migration SQL script(s) is created and it does the following actions:
    - adds email column to users table
    - updates users email column value to concatenation of username and @golf.com
    - creates unique index users email
- Make sure that the migration SQL script(s) is executed on the application database without errors
- Make sure that the application is built without errors
- Make sure that the application is launched without errors
- Make sure that a new user can be registered
- Make sure that a new user can login after registration
</details>


<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md) and extra steps described below.

Extra steps:
- Test registration of a new user
- Test login of a new user
- Add results of the registration test and login test to output.md. See [manual-testing-template.md](manual-testing-template.md).

</details>

*Additional note*

See a sample of correct solution in the [0001-Fix-up-user-registration.patch](exemplar/0001-Fix-up-user-registration.patch).
