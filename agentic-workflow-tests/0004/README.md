**0004. Return CSV response**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - pom.xml
    - src/main/java/com/golf/app/AppConfiguration.java
    - src/main/java/com/golf/app/controller/RoundScoreController.java
    - src/main/java/com/golf/app/model/Competition.java
    - src/main/java/com/golf/app/model/Player.java
    - src/main/java/com/golf/app/model/RoundScore.java
    - src/main/java/com/golf/app/model/Score.java
    - src/main/java/com/golf/app/dto/RoundScoreDto.java
    - src/main/resources/templates/round-score/round-score-main.html
- Enter task description:

```
The application returns RoundScore page in HTML format in response to /round-score request.
Modify the application to return response in CSV format if a client makes /round-score request with Accept HTTP header indicating that it expects text/csv content. CSV response should contain the same fields as scorecardsTable in the given round-score-main.html.
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assert conditions*

- update database configuration in application.properties to match it with your local environment.
- build the application with the command: `mvn clean install`.
- make sure the application has been built without errors.
- start the application:

```bash
mvn spring-boot:run
```

- make sure the application has started, no errors are reported in log
- assert that application responds with CSV response to  _ /round-score _  request with HTTP header  _ "Accept: text/csv" _  
    - send the request

```bash
curl -s -v -u 1:1 --header 'accept: text/csv' http://localhost:8082/round-score
```

    - verify the response:
        - HTTP status code: 200
        - Content-Type: text/csv;charset=UTF-8
        - Body contains CSV response like the following one:

```csv
Id,Date,Player,HCP,Competition,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,Stroke,Penalty,GrossScore,NetScore,NetScorePar,Stableford
37,2024-04-01,LAGERLÖF Ögge,36.0,2024,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,81,0,81,45,-27,63
49,2024-04-14,TALKACHOVA Palina,5.0,may,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,90,0,90,85,13,23
69,2024-03-03,ZHUK Aliaksandr,17.0,third,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,33,84,0,84,67,-5,67
70,2024-03-03,ZHUK Aliaksandr,17.0,third,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,333,384,0,384,367,295,67
71,2024-03-03,AGARWALLA Anjali,24.0,third,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,90,0,90,66,-6,42
```

*Sample Implementation*

> :memo: **Note:** Generated source code changes may differ. It all depends upon chosen approach, selected CSV library, etc.

- CSV library is added to pom.xml:

```xml
<dependency>
    <groupId>de.siegmar</groupId>
    <artifactId>fastcsv</artifactId>
    <version>3.2.0</version>
</dependency>
```

- GenericHttpMessageConverter implementation is added to convert RoundScore collection to CSV: [RoundScoreCsvHttpMessageConverter](RoundScoreCsvHttpMessageConverter.java)
- RoundScoreCsvHttpMessageConverter is added as a custom converter bean to AppConfiguration:

```java
    @Bean
    HttpMessageConverters customConverters()
    {
        HttpMessageConverter<?> csv = new RoundScoreCsvHttpMessageConverter();
        return new HttpMessageConverters( csv );
    }
```

- text/csv endpoint is added to RoundScoreController:

```java
    @GetMapping(produces = "text/csv")
    @ResponseBody
    public List<RoundScore> getRoundScores()
    {
        Iterable<RoundScore> iRoundScores = roundScoreService.getAllRoundScores();
        List<RoundScore> roundScores = StreamSupport.stream( iRoundScores.spliterator(), false )
                .collect( Collectors.toList() );
        return roundScores;
    }
```