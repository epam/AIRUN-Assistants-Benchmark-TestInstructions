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

*Assert conditions*

- assert that DB initialization script is created. Sample script name: src/main/resources/db/migration/V1__Initial_Schema.sql
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

- start Mysql container with the command: docker-compose up
- migrate the database with the command: flyway -configFiles=src/main/resources/flyway.conf migrate
- start the application with the following command with actual DB url and password:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.url=jdbc:mysql://localhost:3306/golf_db?allowPublicKeyRetrieval=true --spring.datasource.username=root --spring.datasource.password=rootpassword --spring.jpa.hibernate.ddl-auto=none"
```

- make sure the application has started, no errors are reported in log
- test the application respond to requests without 500 error:

```bash
curl -v -u 1:1 http://localhost:8082/competition/data/1/round

curl -v -u 1:1 http://localhost:8082/player/1

curl -v -u 1:1 http://localhost:8082/round/1
```
