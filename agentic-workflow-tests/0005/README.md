
# 0005. Publish competition change events to Kafka


**Category:** solution-or-component-generation  
**Complexity:** high  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)

### Technologies

- Kafka

## Task

```md
The application allows to manage golf competitions.
Add publishing competition change events to Kafka.
A change event should include change type and the following competition attributes: Id,
competition name, start date, end date, course name.
```

## Context

### Files

- `pom.xml`
- `src/main/resources/application.properties`
- `src/main/java/com/golf/app/AppConfiguration.java`
- `src/main/java/com/golf/app/mapper/CompetitionMapper.java`
- `src/main/java/com/golf/app/model/Competition.java`
- `src/main/java/com/golf/app/service/CompetitionService.java`
- `src/main/java/com/golf/app/service/CompetitionServiceImpl.java`
- `src/main/java/com/golf/app/repo/CompetitionRepository.java`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to make it compatible with your local environment
- Update Kafka configuration in application.properties to match it with your local environment
- Set KAFKA_FROM_HOST environment variable: `export KAFKA_FROM_HOST=your_kafka_host`
- Start the container with the command: `docker-compose up`
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.springframework.kafka=INFO --logging.level.org.apache.kafka=INFO"`
- Open application UI at http://localhost:8082/
- Click  *Competitions*  link and edit competitions:
                    - create a competition
                    - update a competition
        
- Open Kafka UI at http://localhost:8080/
- Click  *Topics* on the sidebar and Golf topic then.
- Click the topic  *Messages*  link and make sure that all competition edits have corresponding Kafka messages.
- Write down the create, update, delete messages to output.md. See (testing-template.md)[testing-template.md]

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Ensure spring-kafka dependency is added in pom.xml.
- **completeness** (==high==)
    - (==high==) Ensure Kafka bootstrap servers have been configured in application.properties.
    - (==high==) Ensure Kafka producer value serializer is configured as Json serializer in application.properties.
    - (==low==) Ensure Kafka topic for Golf competitions publishing is configured in application.properties.
- **completeness** (==high==)
    - (==high==) Make sure that competition save invokes publishing of competition change event to Kafka.
    - (==high==) Make sure that competition update invokes publishing of competition change event to Kafka.
    - (==high==) Make sure that competition deletion invokes publishing of competition change event to Kafka.
- **completeness** (==high==)
    - (==high==) Ensure Transactional Outbox pattern is used to publish competition change event to Kafka.
- **completeness** (==high==)
    - (==high==) Ensure that competition SAVE message published to Kafka.
    - (==high==) Ensure that competition SAVE message has the following attributes: Id, competition name, start date, end date, course name.
    - (==high==) Ensure that competition UPDATE message published to Kafka.
    - (==high==) Ensure that competition UPDATE message has the following attributes: Id, competition name, start date, end date, course name.
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

- See sample of correct solution in the [exemplar directory](exemplar).