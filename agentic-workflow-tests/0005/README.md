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

> The application allows to manage golf competitions.
Add publishing competition change events to Kafka topic.
A change event should include change type and the following competition attributes: Id,
competition name, start date, end date, course name.

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
golf.kafka.topicName=golf
golf.kafka.publish.batchSize=10
golf.kafka.publish.delay=10000
```

- assert Java code changes are generated
- set KAFKA_FROM_HOST variable to point actual Kafka host in (.env)[.env] docker compose configuration file file
- start Mysql container and Kafka containers with the command:

```bash
docker-compose up
```

- set env variables to specify actual Mysql and Kafka hosts:

```bash
export MYSQL_HOST=host1
export KAFKA_HOST=host1
```

- start the application with the following command with actual DB url and password:

```bash
mvn spring-boot:run
```

- open the application UI at http://localhost:8082/
- click  *Competitions*  link and edit competitions:
    - create a competition
    - update a competition
    - delete a competition
- open Kafka UI at http://host1:8080/
- click  *Topics* on sidebar and Golf topic then.
- click topic  *Messages*  link and make sure that all competition edits have corresponding Kafka messages.
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

*Sample Implementation*

> :memo: **Note:** Generated source code changes may differ. It all depends upon chosen approach.

[Sample](0001-0005.-Publish-competition-change-events-to-Kafka-top.patch) is implemented following [Transactional Outbox pattern](https://microservices.io/patterns/data/transactional-outbox.html).

Short description:
- pom.xml: added spring-kafka dependency
- src/main/java/com/golf/app/AppConfiguration.java:
    - enabled scheduling: `@EnableScheduling`
    - added [NewTopic](https://kafka.apache.org/24/javadoc/org/apache/kafka/clients/admin/NewTopic.html) bean to create Kafka topic at first start
- src/main/java/com/golf/app/event/AppEvent.java: application aggregate event class
- src/main/java/com/golf/app/event/DomainEvent.java: domain event interface
- src/main/java/com/golf/app/event/CompetitionEvent.java: competition change event class
- src/main/java/com/golf/app/mapper/CompetitionMapper.java:
    - added appEventCompetitionEventUpserted default method to convert Competition to CompetitionEvent.Upserted aggregate event
    - added appEventCompetitionEventDeleted default method to convert Competition to CompetitionEvent.Upserted aggregate event
    - added competitionEventUpserted mapping to convert Competition to CompetitionEvent.Upserted domain event
    - added competitionEventDeleted mapping to convert Competition to CompetitionEvent.Deleted domain event
- src/main/java/com/golf/app/model/Outbox.java: Outbox entity
- src/main/java/com/golf/app/repo/OutboxRepository.java: Outbox repository definition
- src/main/java/com/golf/app/service/CompetitionServiceImpl:
    - updated saveCompetition method to publish application event  _ CompetitionEvent.Upserted _  during Competition save
    - updated deleteCompetition method to publish application event  _ CompetitionEvent.Deleted _  during Competition deletion
- src/main/java/com/golf/app/service/OutboxListenerService.java: service to listen Competition change application events and save them into Outbox table
- src/main/java/com/golf/app/service/OutboxPublisherService.java: service to pick up Competition change application events from Outbox table and send them to Kafka topic
- src/main/resources/application.properties:
    - added spring-kafka configuration
    - added application configuration for Kafka publishing

