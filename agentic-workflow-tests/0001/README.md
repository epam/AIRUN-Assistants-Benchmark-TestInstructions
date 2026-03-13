
# 0001. Make reverse engineering of DB schema and make it manageable with Flyway


**Category:** code-refactoring  
**Complexity:** medium  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- SQL

### Technologies

- Docker
- MySQL
- Flyway

## Task

```md
The directory src/main/java/com/golf/app/model contains Java entities classes used by Jakarta Persistence.

Create DML script to create Mysql database schema with tables corresponding to the given entities.

The script should be used by Flyway to continuously remodel the database schema.

Create Flyway configuration file in CONF format to manage database externally.

Create a Docker Compose file to manage the MySQL container to be used for development and testing.
```

## Context

### Files

- `src/main/java/com/golf/app/model/Competition.java`
- `src/main/java/com/golf/app/model/Course.java`
- `src/main/java/com/golf/app/model/Hole.java`
- `src/main/java/com/golf/app/model/Judge.java`
- `src/main/java/com/golf/app/model/Marker.java`
- `src/main/java/com/golf/app/model/Par.java`
- `src/main/java/com/golf/app/model/Player.java`
- `src/main/java/com/golf/app/model/PlayerPhoto.java`
- `src/main/java/com/golf/app/model/Round.java`
- `src/main/java/com/golf/app/model/RoundScore.java`
- `src/main/java/com/golf/app/model/Score.java`
- `src/main/java/com/golf/app/model/ScoreCard.java`
- `src/main/java/com/golf/app/model/ScoreCardImage.java`
- `src/main/java/com/golf/app/model/StrokeIndex.java`
- `src/main/java/com/golf/app/model/Team.java`
- `src/main/java/com/golf/app/model/Tee.java`
- `src/main/java/com/golf/app/model/User.java`
- `src/main/resources/application.properties`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to match it with your local environment
- Update database configuration in flyway.conf to match it with your local environment
- Start Mysql container with the command: `docker-compose up`
- Migrate the database with the command: `flyway -configFiles=flyway.conf migrate`
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments=--spring.jpa.hibernate.ddl-auto=validate`
- Send test requests to the application:

```bash
curl -i -u 1:1 http://localhost:8082/competition/2025

curl -i -u 1:1 http://localhost:8082/player

curl -i -u 1:1 http://localhost:8082/round
```

        

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==low==) Ensure that DB initialization migration script is created in src/main/resources/db/migration/ directory.
    - (==high==) Ensure that DB migration applied successfully without DATABASE SCHEMA errors.
    - (==high==) Ensure that database schema validation passed without errors during the application launch.
- **completeness** (==low==)
    - (==high==) Ensure that flyway.conf is created.
    - (==high==) Ensure that Flyway migration has been completed without errors.
- **completeness** (==low==)
    - (==high==) Ensure that docker-compose.yml file is created.
    - (==high==) Ensure that docker-compose.yml contains definitions of mysql service.
    - (==high==) Ensure that docker-compose.yml contains definitions of mysql data volume.
    - (==high==) Ensure that Mysql container started without error with the command `docker-compose up`.
- **completeness** (==medium==)
    - (==high==) Ensure that Hibernate configuration is changed from updating database schema to validating database schema.
- **completeness** (==medium==)
    - (==high==) Make sure that the application is built without errors
    - (==high==) Make sure that the application is launched without errors
- **completeness** (==high==)
    - (==high==) Make sure the application responds to GET request http://localhost:8082/competition/2025 without server error (500-599).
    - (==high==) Make sure the application responds to GET request http://localhost:8082/player without server error (500-599).
    - (==high==) Make sure the application responds to GET request http://localhost:8082/round without server error (500-599).
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