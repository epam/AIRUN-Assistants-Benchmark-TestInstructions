
# 0003. Refactor Golf application access-control layer, replace Basic Authentication with Oauth2 Authorization


**Category:** code-refactoring  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

N/A


## Task

```md
Refactor Golf application access-control layer, replace Basic Authentication with OAuth2 authorization.

Establish scope-based authorization:
- /admin endpoint should be accessed only by a client granted with GOLF:ADMIN scope.
- a client granted with GOLF:COACH scope should access all endpoints except /admin endpoint.
- a client granted with GOLF:USER scope should access all read only endpoints except /admin endpoint.
```

## Context

### Files

- `pom.xml`
- `src/main/resources/application.properties`
- `src/main/java/com/golf/app/security/AppSecurityConfig.java`
- `src/main/java/com/golf/app/controller/AdminController.java`
- `src/main/java/com/golf/app/controller/CompetitionController.java`
- `src/main/java/com/golf/app/controller/CompetitionExceptionHandlerController.java`
- `src/main/java/com/golf/app/controller/CourseController.java`
- `src/main/java/com/golf/app/controller/ExceptionHandlerController.java`
- `src/main/java/com/golf/app/controller/MainController.java`
- `src/main/java/com/golf/app/controller/PlayerController.java`
- `src/main/java/com/golf/app/controller/PlayerPhotoController.java`
- `src/main/java/com/golf/app/controller/RoundController.java`
- `src/main/java/com/golf/app/controller/RoundScoreController.java`
- `src/main/java/com/golf/app/controller/ScoreCardController.java`
- `src/main/java/com/golf/app/controller/ScoreCardImageController.java`
- `src/main/java/com/golf/app/controller/UserController.java`

## Arrangement

- download WireMock JWT Standalone extension with the command:

```bash
(cd extensions && curl -O https://repo1.maven.org/maven2/org/wiremock/extensions/wiremock-jwt-extension-standalone/0.3.0/wiremock-jwt-extension-standalone-0.3.0.jar)
```

        
- start Mysql container and OAuth2 authorization server container with the command:

```bash
docker-compose up
```

        

## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- update database configuration in application.properties to match it with your local environment
- update OAUTH2 resource server URI configuration in application.properties to match it with your local environment
- build the application with the command: `mvn clean install`
- start the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.springframework.security=DEBUG"`
- assert /admin request is accessible with GOLF:ADMIN scope by running the commands:

```bash
GOLF_SCOPE=GOLF:ADMIN
ACCESSTOKEN=`curl -s --request POST --url ${GOLF_APP_OAUTH2_ISSUER_URI}/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=${GOLF_SCOPE}" | jq -r .access_token`

echo GOLF_SCOPE=$GOLF_SCOPE
curl -i --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/admin
```

        
- verify the response:

```
HTTP status code: 200
Content-Type: text/plain;charset=UTF-8
Body: admin
```

        
- assert /admin request is not accessible with scope other than GOLF:ADMIN by running the commands:

```bash
GOLF_SCOPE=GOLF:COACH
ACCESSTOKEN=`curl -s --request POST --url ${GOLF_APP_OAUTH2_ISSUER_URI}/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=${GOLF_SCOPE}" | jq -r .access_token`

echo GOLF_SCOPE=$GOLF_SCOPE
curl -i --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/admin
```

        
- verify the response:

```
HTTP status code: 403
WWW-Authenticate: Bearer error="insufficient_scope", error_description="The request requires higher privileges than provided by the access token.", error_uri="https://tools.ietf.org/html/rfc6750#section-3.1"
```

        
- assert /player/add GET request is accessible with GOLF:USER scope by running the commands:

```bash
GOLF_SCOPE=GOLF:USER
ACCESSTOKEN=`curl -s --request POST --url ${GOLF_APP_OAUTH2_ISSUER_URI}/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=${GOLF_SCOPE}" | jq -r .access_token`

echo GOLF_SCOPE=$GOLF_SCOPE
curl -i --header "Authorization: Bearer $ACCESSTOKEN" http://localhost:8082/player/add
```

        
- verify the response:

```
HTTP status code: 200
Content-Type: text/html;charset=UTF-8
Body contains src/main/resources/templates/player/player-add.html
```

        
- assert /player/add POST request is accessible with GOLF:COACH scope by running the commands:

```bash
GOLF_SCOPE=GOLF:COACH
ACCESSTOKEN=`curl -s --request POST --url ${GOLF_APP_OAUTH2_ISSUER_URI}/oauth2/token -u u1:p1 --header 'accept: application/json' --header 'content-type: application/x-www-form-urlencoded' --data "grant_type=client_credentials&scope=${GOLF_SCOPE}" | jq -r .access_token`

echo GOLF_SCOPE=$GOLF_SCOPE
curl -i --header "Authorization: Bearer $ACCESSTOKEN" --header "Content-Type: application/x-www-form-urlencoded" --request POST --data 'name=Naomi&surname=OsaAF' http://localhost:8082/player/add
```

        
- verify the response:

```
HTTP status code: 302
Location: http://localhost:8082/player
```

        
- add results of the manual tests to output.md.

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure that spring-boot-starter-oauth2-resource-server dependency is added to pom.xml.
    - (==high==) Ensure that authorization server URI is specified by `spring.security.oauth2.resourceserver.jwt.issuer-uri` property in application.properties.
    - (==high==) Ensure that EXTERNAL authorization server is configured.
- **completeness** (==high==)
    - (==high==) Ensure that OAuth2 authorization is configured in Spring configuration.
    - (==high==) Ensure that access to /admin endpoint is restricted to clients granted with GOLF:ADMIN scope.
    - (==high==) Ensure that clients granted with GOLF:COACH scope have access to all endpoints except /admin endpoint.
    - (==high==) Ensure that clients granted with GOLF:USER scope have access to read only endpoints except /admin endpoint.
    - (==high==) Ensure that the application is explicitly configured to deny access by default for newly added endpoints.
- **completeness** (==low==)
    - (==high==) Ensure that in-memory user details management is removed from Spring configuration.
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

- See [testing-template.md](testing-template.md)