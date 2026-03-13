
# 0007. Migrate Golf application to reactive stack


**Category:** code-refactoring  
**Complexity:** High  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

- Spring Boot
- Spring WebFlux
- Spring Data R2DBC
- Project Reactor

## Task

```md
# WHY
Improve the Golf application scalability, performance, and resource efficiency.

# WHAT

Migrate Spring MVC application with Thymeleaf templating to a fully reactive stack using Spring WebFlux and reactive Thymeleaf support.

Scope:
- Web layer migration (Controllers → Reactive Controllers)
- Service layer refactoring to reactive patterns
- Data access layer migration to reactive repositories
- Template engine configuration for reactive support
- Security migration to Spring Security Reactive
- Testing strategy adaptation

# HOW

## Target Stack

- Spring Boot 3.x (Reactive Support)
- Spring WebFlux
- Thymeleaf 3.1+ (Reactive Support)
- Spring Data R2DBC
- Netty (Reactive Server)
- Spring Security Reactive
- Reactive Session Management
```

## Context

### Files

- `pom.xml`
- `src/main/java/com/golf/app/AppConfiguration.java`
- `src/main/java/com/golf/app/GolfWebApplication.java`
- `src/main/java/com/golf/app/api/CompetitionRestController.java`
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
- `src/main/java/com/golf/app/repo/CompetitionRepository.java`
- `src/main/java/com/golf/app/repo/CourseRepository.java`
- `src/main/java/com/golf/app/repo/MarkerRepository.java`
- `src/main/java/com/golf/app/repo/ParRepository.java`
- `src/main/java/com/golf/app/repo/PlayerPhotoRepository.java`
- `src/main/java/com/golf/app/repo/PlayerRepository.java`
- `src/main/java/com/golf/app/repo/RoundRepository.java`
- `src/main/java/com/golf/app/repo/RoundScoreRepository.java`
- `src/main/java/com/golf/app/repo/ScoreCardImageRepository.java`
- `src/main/java/com/golf/app/repo/ScoreCardRepository.java`
- `src/main/java/com/golf/app/repo/UserRepository.java`
- `src/main/java/com/golf/app/service/CompetitionService.java`
- `src/main/java/com/golf/app/service/CompetitionServiceImpl.java`
- `src/main/java/com/golf/app/service/CourseService.java`
- `src/main/java/com/golf/app/service/CourseServiceImpl.java`
- `src/main/java/com/golf/app/service/MarkerService.java`
- `src/main/java/com/golf/app/service/ParService.java`
- `src/main/java/com/golf/app/service/ParServiceImpl.java`
- `src/main/java/com/golf/app/service/PlayerPhotoService.java`
- `src/main/java/com/golf/app/service/PlayerPhotoServiceImpl.java`
- `src/main/java/com/golf/app/service/PlayerService.java`
- `src/main/java/com/golf/app/service/PlayerServiceImpl.java`
- `src/main/java/com/golf/app/service/RoundScoreService.java`
- `src/main/java/com/golf/app/service/RoundScoreServiceImpl.java`
- `src/main/java/com/golf/app/service/RoundService.java`
- `src/main/java/com/golf/app/service/RoundServiceImpl.java`
- `src/main/java/com/golf/app/service/ScoreCardImageService.java`
- `src/main/java/com/golf/app/service/ScoreCardImageServiceImpl.java`
- `src/main/java/com/golf/app/service/ScoreCardService.java`
- `src/main/java/com/golf/app/service/ScoreCardServiceImpl.java`
- `src/main/java/com/golf/app/service/UserService.java`
- `src/main/java/com/golf/app/service/UserServiceImpl.java`
- `src/main/resources/application.properties`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to match it with your local environment
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run`
- Open application UI at http://localhost:8082/
- Visit the "PLAYERS" page and make sure the player list is displayed there
- Visit the "ROUND SCORES" page and make sure the round score list is displayed there
- Visit the "COMPETITIONS" page and make sure the competition list is displayed there
- Visit the the "COURSE" page and make sure the course list is displayed there
- Make sure the competition can be created on the "ADD COMPETITION" page

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure the `spring-boot-starter-web` dependency is removed in `pom.xml`.
    - (==high==) Ensure the `spring-boot-starter-data-jpa` dependency is removed in `pom.xml`.
    - (==high==) Ensure the MySQL JDBC driver dependency is removed in `pom.xml`.
    - (==high==) Ensure the `spring-boot-starter-webflux` dependency is added in `pom.xml`.
    - (==high==) Ensure the `spring-boot-starter-data-r2dbc` dependency is added in `pom.xml`.
    - (==high==) Ensure the MySQL R2BC driver dependency is added in `pom.xml`.
    - (==high==) Ensure the `reactor-test` dependency is added in `pom.xml`.
- **completeness** (==high==)
    - (==high==) Ensure `spring.datasource.*` properties are removed in `src/main/resources/application.properties`.
    - (==high==) Ensure `spring.r2dbc.url` property is configured in `src/main/resources/application.properties`.
    - (==high==) Ensure `spring.r2dbc.username` property is configured in `src/main/resources/application.properties`.
    - (==high==) Ensure `spring.r2dbc.password` property is configured in `src/main/resources/application.properties`.
- **completeness** (==high==)
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Competition`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Course`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Hole`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Judge`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Marker`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Par`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Player`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `PlayerPhoto`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Round`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `RoundScore`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Score`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `ScoreCard`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `ScoreCardImage`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `StrokeIndex`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Team`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `Tee`.
    - (==high==) Ensure JPA annotations are replaced with R2DBC annotations in `User`.
- **completeness** (==high==)
    - (==high==) Ensure `CompetitionRestController` is converted to reactive controller.
    - (==high==) Ensure `AdminController` is converted to reactive controller.
    - (==high==) Ensure `CompetitionController` is converted to reactive controller.
    - (==high==) Ensure `CompetitionExceptionHandlerController` is converted to reactive controller.
    - (==high==) Ensure `CourseController` is converted to reactive controller.
    - (==high==) Ensure `ExceptionHandlerController` is converted to reactive controller.
    - (==high==) Ensure `MainController` is converted to reactive controller.
    - (==high==) Ensure `PlayerController` is converted to reactive controller.
    - (==high==) Ensure `PlayerPhotoController` is converted to reactive controller.
    - (==high==) Ensure `RoundController` is converted to reactive controller.
    - (==high==) Ensure `RoundScoreController` is converted to reactive controller.
    - (==high==) Ensure `ScoreCardController` is converted to reactive controller.
    - (==high==) Ensure `ScoreCardImageController` is converted to reactive controller.
    - (==high==) Ensure `UserController` is converted to reactive controller.
- **completeness** (==high==)
    - (==high==) Ensure `CompetitionRepository` is migrated to reactive repository.
    - (==high==) Ensure `CourseRepository` is migrated to reactive repository.
    - (==high==) Ensure `MarkerRepository` is migrated to reactive repository.
    - (==high==) Ensure `ParRepository` is migrated to reactive repository.
    - (==high==) Ensure `PlayerPhotoRepository` is migrated to reactive repository.
    - (==high==) Ensure `PlayerRepository` is migrated to reactive repository.
    - (==high==) Ensure `RoundRepository` is migrated to reactive repository.
    - (==high==) Ensure `RoundScoreRepository` is migrated to reactive repository.
    - (==high==) Ensure `ScoreCardImageRepository` is migrated to reactive repository.
    - (==high==) Ensure `ScoreCardRepository` is migrated to reactive repository.
    - (==high==) Ensure `UserRepository` is migrated to reactive repository.
- **completeness** (==high==)
    - (==high==) Ensure `CompetitionService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `CompetitionServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `CourseService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `CourseServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ParService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ParServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `PlayerPhotoService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `PlayerPhotoServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `PlayerService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `PlayerServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `RoundScoreService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `RoundScoreServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `RoundService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `RoundServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ScoreCardImageService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ScoreCardImageServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ScoreCardService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `ScoreCardServiceImpl` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `UserService` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `UserServiceImpl` is converted from blocking patterns to reactive patterns.
- **completeness** (==high==)
    - (==high==) Ensure `CustomAccessDeniedHandler` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `CustomAuthenticationFailureHandler` is converted from blocking patterns to reactive patterns.
    - (==high==) Ensure `CustomLogoutSuccessHandler` is converted from blocking patterns to reactive patterns.
- **completeness** (==high==)
    - (==high==) Ensure R2DBC are enabled in Spring configuration.
    - (==high==) Ensure WebFlux security is enabled in Spring configuration.
    - (==high==) Ensure `InMemoryUserDetailsManager` is replaced with `MapReactiveUserDetailsService` in Spring configuration.
    - (==high==) Ensure servlet filter chain is replaced with WebFilter chain in Spring configuration.
- **completeness** (==high==)
    - (==high==) Ensure that database schema management is addressed after removing the Hibernate management.
- **completeness** (==high==)
    - (==high==) Make sure that the application is built without errors
    - (==high==) Make sure that the application is launched without errors
- **completeness** (==high==)
    - (==high==) Make sure the player list is displayed on the "PLAYERS" page
    - (==high==) Make sure the round score list is displayed on the "ROUND SCORES" page
    - (==high==) Make sure the competition list is displayed on the "COMPETITIONS" page
    - (==high==) Make sure the course list is displayed on the "COURSE" page
    - (==high==) Make sure the competition can be created on the "ADD COMPETITION" page
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