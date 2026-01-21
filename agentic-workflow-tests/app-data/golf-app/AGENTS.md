# Project Instructions

## Code Style and Structure

- Write clean, efficient, and well-documented Java code.
- Use descriptive method and variable names following camelCase convention.
- Avoid code duplication by extracting logic into reusable methods or classes.
- Prefer simple solutions over complex ones, breaking down large methods into smaller, focused ones.
- Adhere to SOLID principles and maintain high cohesion and low coupling.
- Use Lombok for boilerplate reduction.
- Follow RESTful API design patterns (proper use of HTTP methods, status codes, etc.).

## Spring Specifics

- Use Spring Boot best practices and conventions throughout your code.
- Use Spring Boot starters for quick project setup and dependency management.
- Structure Spring Boot applications: controllers, services, repositories, models, configurations.
- Implement proper use of annotations (e.g., @SpringBootApplication, @RestController, @Service).
- Utilize Spring Boot's auto-configuration features effectively.
- Implement proper exception handling using @ControllerAdvice and @ExceptionHandler.
- Use Spring Data JPA for database operations when applicable.
- Implement proper validation using Bean Validation (e.g., @Valid, custom validators).

## Naming Conventions

- Use PascalCase for class names (e.g., UserController, OrderService).
- Use camelCase for method and variable names (e.g., findUserById, isOrderValid).
- Use ALL_CAPS for constants (e.g., MAX_RETRY_ATTEMPTS, DEFAULT_PAGE_SIZE).

## Java and Spring Boot Usage

- Use Java 17 or later features when applicable (e.g., records, sealed classes, pattern matching).
- Avoid magic numbers and strings; use constants instead.
- Avoid methods using `throws` clause; prefer unchecked exceptions.
- Wrap a return value in a variable for better readability and debuggability.
- Prefer early returns.
- Avoid returning or accepting `null`.

## Configuration and Properties

- Use application.properties or application.yml for configuration.
- Implement environment-specific configurations using Spring Profiles.

## Dependency Injection and IoC

- Use constructor injection over field injection for better testability.
- Leverage Spring's IoC container for managing bean lifecycles.

## Testing

- Write unit tests using JUnit 5 and Spring Boot Test.
- Use MockMvc for testing web layers.
- Implement integration tests using @SpringBootTest.
- Use @DataJpaTest for repository layer tests.

## Security

- Implement Spring Security for authentication and authorization.
- Use proper password encoding (e.g., BCrypt).
- Implement CORS configuration when necessary.

## Logging and Monitoring

- Use SLF4J logging facade.
- Implement proper log levels (ERROR, WARN, INFO, DEBUG).

## Data Access and ORM

- Use Spring Data JPA for database operations.
- Implement proper entity relationships and cascading.

## Build and Deployment

- Use Maven for dependency management and build processes.
- Implement proper profiles for different environments (dev, test, prod) when necessary.
- Use Docker for containerization if applicable.
