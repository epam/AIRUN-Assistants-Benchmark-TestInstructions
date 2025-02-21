**0008. Refactor Golf application, replace logback logging with Log4j 2.x logging framework and SLF4J as logging facade**

*Act*

- Open the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application 
- Copy logback-spring.xml to golf-application/src/main/resources/logback-spring.xml

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/resources/application.properties
    - src/main/resources/logback-spring.xml
    - src/main/resources/logging.properties
    - pom.xml
    - src/main/java/com/golf/app/controller/PlayerController.java
    - src/main/java/com/golf/app/security/CustomAccessDeniedHandler.java
- Enter task description:

```
Refactor Golf application, replace logback logging with log4j2.

# migration

Migrate logback configuration to log4j2 configuration.
Configure log4j2 for performance.

# logging
Unify the application logging by using SLF4J logging facade:
- replace all other loggers with SLF4J loggers everywhere in the application.
- use Lombok annotation to declare logger whether it is used in class.
- replace printing to system standard output with SLF4J logging in all classes.

# cleanup
Cleanup unused or legacy logging configuration.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Make sure, the following changes suggested in pom.xml:
    - `spring-boot-starter-logging` excluded from `org.springframework.boot` dependencies:

```xml
           <exclusions>
               <exclusion>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-logging</artifactId>
               </exclusion>
           </exclusions>
```

    - log4j2 dependencies are added:

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        <dependency>
            <groupId>com.lmax</groupId>
            <artifactId>disruptor</artifactId>
            <version>3.4.4</version>
        </dependency>
```

-  _ src/main/resources/logback-spring.xml _  is deleted.
- Make sure there is not logback dependency by running the command `mvn dependency:tree -Dincludes=ch.qos.logback:*`
-  _ src/main/resources/logging.properties _  is deleted.
- Removed logging configuration from  _ src/main/resources/application.properties _  :

```diff
-# Logging Configuration
-logging.level.org.springframework=INFO
-logging.level.com.myapp=DEBUG
```

-  _  src/main/resources/log4j2.xml _  is created and have declaration of the following elements (see exemplar/log4j2.xml sample):
    - Console appender.
    - RollingRandomAccessFile appender.
    - AsyncLogger for "com.golf.app".
    - AsyncLogger for "org.springframework.web".
    - AsyncRoot logger.
- `PlayerController` class has the following updates:
    - `@Slf4j` annotation is added to the class.
    - `LOGGER` field declaration is removed.
    - `addPlayer` method logging is changed to `log.info( "Player {} {} with ID {} has been saved in the DB", player.getSurname(), player.getName(), player.getId() );`.
    - `updatePlayer` method logging is changed to `log.info( "Player {} {} with ID {} has been updated in the DB", player.getSurname(), player.getName(), player.getId() );`.
    - `deletePlayer` method logging is changed to `log.info( "Player {} {} with ID {} was REMOVED from DB", player.getSurname(), player.getName(), player.getId() );`.
- `CustomAccessDeniedHandler` class has the following updates:
    - `@Slf4j` annotation is added to the class.
    - `LOG` field declaration is removed.
    - `handle` method logging is changed to `log.warn( "User: {} attempted to access the protected URL: {}", auth.getName(), request.getRequestURI() );`.
- `CompetitionController` class has the following updates:
    - `@Slf4j` annotation is added to the class.
    - all calls of `System.out.println( ... )` are replaced with `log.info( ... );`.
- `RoundController` class has the following updates:
    - `@Slf4j` annotation is added to the class.
    - all calls of `System.out.println( ... )` are replaced with `log.info( ... );`.
- `CustomLogoutSuccessHandler` class has the following updates:
    - `@Slf4j` annotation is added to the class.
    - `System.out.println( ... )` call is replaced with `log.info( ... );`.
- The application successfully built with the command `mvn clean install`.
- The application is run with the command `mvn spring-boot:run` and logs are written to console and to  _ logs/golf-app.log _  file.
</details>

<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md).

The following manual steps are required before running the evaluation (see [template](../auto-llm-eval/manual-output-include-template.md) ):
- Add output of `mvn clean install` to output.md.
- Add output of `mvn dependency:tree -Dincludes=ch.qos.logback:*` to output.md.
- Add output of `mvn spring-boot:run` to output.md.
- Add content of logs/golf-app.log to output.md.

</details>
