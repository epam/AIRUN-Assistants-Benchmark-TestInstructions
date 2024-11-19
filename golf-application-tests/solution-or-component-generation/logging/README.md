**Logging test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to file src/main/resources/logback-spring.xml
- Highlight the code
- Open the chat AI interface and enter:

> Add configuration to the existing logback-spring.xml file to log to the application.log file and save the log file in the log folder

- Submit the question
- Update the src/main/resources/logback-spring.xml file with the suggested code
- Delete log/application.log folder if it exists

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    -  src/main/resources/logback-spring.xml
- Enter task description:

> Add configuration to the existing logback-spring.xml file to log to the application.log file and save the log file in the log folder

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Run the project using the class src/main/java/com/golf/app/GolfWebApplication.java
- Close and open the Golf application project in IDE
- The application.log file should be added to the logs folder and contain the logs

*Additional note*

The correct solution should include two modifications in logback-spring.xml:
- file appender configuration is added:

```xml
<!-- File Appender -->
<appender name="file" class="ch.qos.logback.core.FileAppender">
    <file>logs/application.log</file>
    <append>true</append>
    <encoder>
        <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %X{data} %msg%n</pattern>
    </encoder>
</appender>
```

- file appender is referenced in Root Logger:

```xml
<!-- Root Logger -->
<root level="info">
    <appender-ref ref="console"/>
    <appender-ref ref="file"/>
</root>
```