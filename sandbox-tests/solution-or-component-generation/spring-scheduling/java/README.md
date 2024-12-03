**Schedule a Task Using Cron Expression in Spring Boot project**

*Test Description*:

A developer is trying to configure a repetitive task execution with a Cron expression in Spring Boot project

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/spring-boot/java
- Open the SchedulingConfig class
- Add annotation to the class `@EnableScheduling`
- Type in the class body and press Enter

```java
// scheduling a task to be executed every five minutes since 7 AM till 11 PM every odd day of the month within Europe/Paris time zone
```

- Accept the best suggested implementation using the TAB and ENTER keys
- Add all necessary imports

</details>


*Assert conditions*

- Code must compile
- Build the project with the command `gradle build` and verify no errors reported
- Run the application with the command `gradle bootRun`
- Verify that a scheduled task is being executed by printed message in the application console

*Additional note*

An example of solution is in the correctResponse.txt file