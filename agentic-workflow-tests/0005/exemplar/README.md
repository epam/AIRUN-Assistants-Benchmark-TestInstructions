# Sample Implementation

> :memo: **Note:** Generated source code changes may differ. It all depends upon chosen approach.

[The sample](0001-0005.-Publish-competition-change-events-to-Kafka-top.patch) is implemented following [Transactional Outbox pattern](https://microservices.io/patterns/data/transactional-outbox.html).

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


# Message sample

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
