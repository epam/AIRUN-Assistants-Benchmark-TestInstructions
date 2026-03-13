
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


- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure the `spring-boot-starter-web` dependency is removed in `pom.xml`.
    - (<mark>high</mark>) Ensure the `spring-boot-starter-data-jpa` dependency is removed in `pom.xml`.
    - (<mark>high</mark>) Ensure the MySQL JDBC driver dependency is removed in `pom.xml`.
    - (<mark>high</mark>) Ensure the `spring-boot-starter-webflux` dependency is added in `pom.xml`.
    - (<mark>high</mark>) Ensure the `spring-boot-starter-data-r2dbc` dependency is added in `pom.xml`.
    - (<mark>high</mark>) Ensure the MySQL R2BC driver dependency is added in `pom.xml`.
    - (<mark>high</mark>) Ensure the `reactor-test` dependency is added in `pom.xml`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure `spring.datasource.*` properties are removed in `src/main/resources/application.properties`.
    - (<mark>high</mark>) Ensure `spring.r2dbc.url` property is configured in `src/main/resources/application.properties`.
    - (<mark>high</mark>) Ensure `spring.r2dbc.username` property is configured in `src/main/resources/application.properties`.
    - (<mark>high</mark>) Ensure `spring.r2dbc.password` property is configured in `src/main/resources/application.properties`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Competition`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Course`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Hole`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Judge`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Marker`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Par`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Player`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `PlayerPhoto`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Round`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `RoundScore`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Score`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `ScoreCard`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `ScoreCardImage`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `StrokeIndex`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Team`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `Tee`.
    - (<mark>high</mark>) Ensure JPA annotations are replaced with R2DBC annotations in `User`.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure `CompetitionRestController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `AdminController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `CompetitionController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `CompetitionExceptionHandlerController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `CourseController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `ExceptionHandlerController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `MainController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `PlayerController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `PlayerPhotoController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `RoundController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `RoundScoreController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `ScoreCardController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `ScoreCardImageController` is converted to reactive controller.
    - (<mark>high</mark>) Ensure `UserController` is converted to reactive controller.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure `CompetitionRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `CourseRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `MarkerRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `ParRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `PlayerPhotoRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `PlayerRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `RoundRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `RoundScoreRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `ScoreCardImageRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `ScoreCardRepository` is migrated to reactive repository.
    - (<mark>high</mark>) Ensure `UserRepository` is migrated to reactive repository.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure `CompetitionService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `CompetitionServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `CourseService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `CourseServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ParService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ParServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `PlayerPhotoService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `PlayerPhotoServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `PlayerService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `PlayerServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `RoundScoreService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `RoundScoreServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `RoundService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `RoundServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ScoreCardImageService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ScoreCardImageServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ScoreCardService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `ScoreCardServiceImpl` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `UserService` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `UserServiceImpl` is converted from blocking patterns to reactive patterns.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure `CustomAccessDeniedHandler` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `CustomAuthenticationFailureHandler` is converted from blocking patterns to reactive patterns.
    - (<mark>high</mark>) Ensure `CustomLogoutSuccessHandler` is converted from blocking patterns to reactive patterns.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure R2DBC are enabled in Spring configuration.
    - (<mark>high</mark>) Ensure WebFlux security is enabled in Spring configuration.
    - (<mark>high</mark>) Ensure `InMemoryUserDetailsManager` is replaced with `MapReactiveUserDetailsService` in Spring configuration.
    - (<mark>high</mark>) Ensure servlet filter chain is replaced with WebFilter chain in Spring configuration.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Ensure that database schema management is addressed after removing the Hibernate management.
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure that the application is built without errors
    - (<mark>high</mark>) Make sure that the application is launched without errors
- **completeness** (<mark>high</mark>)
    - (<mark>high</mark>) Make sure the player list is displayed on the "PLAYERS" page
    - (<mark>high</mark>) Make sure the round score list is displayed on the "ROUND SCORES" page
    - (<mark>high</mark>) Make sure the competition list is displayed on the "COMPETITIONS" page
    - (<mark>high</mark>) Make sure the course list is displayed on the "COURSE" page
    - (<mark>high</mark>) Make sure the competition can be created on the "ADD COMPETITION" page
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

- See [testing-template.md](testing-template.md)