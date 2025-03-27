**0005. Publish competition change events to Kafka topic**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - pom.xml
    - src/main/resources/application.properties
    - src/main/java/com/golf/app/AppConfiguration.java
    - src/main/java/com/golf/app/mapper/CompetitionMapper.java
    - src/main/java/com/golf/app/model/Competition.java
    - src/main/java/com/golf/app/service/CompetitionService.java
    - src/main/java/com/golf/app/service/CompetitionServiceImpl.java
    - src/main/java/com/golf/app/repo/CompetitionRepository.java
- Enter task description:

```
The application allows to manage golf competitions.
Add publishing competition change events to Kafka topic.
A change event should include change type and the following competition attributes: Id,
competition name, start date, end date, course name.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assert conditions*

- assert that spring-kafka dependency is added to pom.xml

```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

- assert that Kafka configuration is added to application.properties

```properties
spring.kafka.bootstrap-servers=${KAFKA_HOST:localhost}:9092
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.consumer.group-id=golf-application
```

- assert that Kafka publishing is configured in application.properties. Sample:

```properties
golf.kafka.topicName=golf-competitions
golf.kafka.publish.batchSize=10
golf.kafka.publish.delay=10000
```

- assert Java code changes are generated
- set KAFKA_FROM_HOST variable to point actual Kafka host in [.env](.env) docker compose configuration file file
- start Mysql container and Kafka containers with the command:

```bash
docker-compose up
```

- update database configuration in application.properties to match it with your local environment.
- update Kafka configuration in application.properties to match it with your local environment.
- build the application with the command: `mvn clean install`.
- make sure the application has been built without errors.
- start the application with the command: `mvn spring-boot:run`.
- make sure the application has started, no errors are reported in log.
- open the application UI at http://localhost:8082/
- click  *Competitions*  link and edit competitions:
    - create a competition
    - update a competition
    - delete a competition
- open Kafka UI at http://localhost:8080/
- click  *Topics* on sidebar and Golf topic then.
- click the topic  *Messages*  link and make sure that all competition edits have corresponding Kafka messages.
- assert that messages have change type and the requested competition attributes. Message sample:

```json
{
    "id": 1,
    "aggregateType": "Competition",
    "aggregateId": "12",
    "eventType": "UPSERTED",
    "payload": {
        "@c": ".CompetitionEvent$Upserted",
        "id": 12,
        "startDate": [
            2024,
            7,
            5
        ],
        "endDate": [
            2024,
            7,
            26
        ],
        "name": "Gold Cup",
        "courseName": "Minsk Golf Club 01"
    }
}
```

*Additional note*

See a [sample](exemplar/) of correct solution.

