**0001. Make reverse engineering of DB schema and make it manageable with Flyway**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - all files from src/main/java/com/golf/app/model directory
    - src/main/resources/application.properties
- Enter task description:

```
The directory src/main/java/com/golf/app/model contains Java entities classes used by Jakarta Persistence.

Create DML script to create Mysql database schema with tables corresponding to the given entities.

The script should be used by Flyway to continuously remodel the database schema.

Create Flyway configuration file in CONF format.

Create a Docker Compose file to manage the MySQL container to be used for development and testing.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Testing*

- Update database configuration in flyway.conf and application.properties to make it compatible with your local environment
- Set property in application.properties: `spring.jpa.hibernate.ddl-auto=validate`
- start Mysql container with the command: `docker-compose up`
- migrate the database with the command: `flyway -configFiles=src/main/resources/flyway.conf migrate`
- build the application with the command: `mvn clean install`
- start the application with the command: `mvn spring-boot:run`
- send test requests to the application:

```bash
curl -v -u 1:1 http://localhost:8082/competition/data/1/round

curl -v -u 1:1 http://localhost:8082/player

curl -v -u 1:1 http://localhost:8082/round
```

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- assert that DB initialization migration script is created. Sample script name: src/main/resources/db/migration/V1__Initial_Schema.sql
- assert that DB initialization script contains correct table definitions for all entities.
- assert that src/main/resources/flyway.conf is created. Sample:

```properties
# flyway.conf

flyway.url=jdbc:mysql://localhost:3306/golf_app?allowPublicKeyRetrieval
flyway.user=root
flyway.password=yourpassword
flyway.schemas=public
flyway.locations=filesystem:src/main/resources/db/migration
```

- assert that docker-compose.yml file is created

```
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: golf_mysql
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: golf_db
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

- make sure the Mysql container has started without errors
- make sure the application has been built without errors
- make sure the application has started, no errors are reported in log
- make sure the application responds to the test requests without server error (500–599)

</details>

<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md).

The following manual steps are required before running the evaluation (see [template](../auto-llm-eval/manual-output-include-template.md) ):
- Add output of `docker-compose up` to output.md.
- Add output of Flyway migration to output.md.
- Add output of `mvn clean install` to output.md.
- Add output of `mvn spring-boot:run` to output.md.
- Add output of the test requests to output.md.

</details>