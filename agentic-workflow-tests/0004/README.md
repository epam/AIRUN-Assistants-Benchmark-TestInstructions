
# 0004. Return round scores in CSV format in Golf application


**Category:** solution-or-component-generation  
**Complexity:** low  
**Repository:** [https://github.com/PolinaTolkachova/golf-application](https://github.com/PolinaTolkachova/golf-application)  

---

## Stack

### Languages

- **Java** (primary)
- HTML
- CSV

### Technologies

N/A


## Task

```md
The application returns RoundScore page in HTML format in response to /round-score request.
Add endpoint returning round scores in CSV format if a client makes a request
with Accept HTTP header indicating that it expects text/csv content.
CSV response should contain the same fields as scorecardsTable in the given round-score-main.html.
```

## Context

### Files

- `pom.xml`
- `src/main/java/com/golf/app/AppConfiguration.java`
- `src/main/java/com/golf/app/api/CompetitionRestController.java`
- `src/main/java/com/golf/app/controller/RoundScoreController.java`
- `src/main/java/com/golf/app/model/Competition.java`
- `src/main/java/com/golf/app/model/Player.java`
- `src/main/java/com/golf/app/model/RoundScore.java`
- `src/main/java/com/golf/app/model/Score.java`
- `src/main/java/com/golf/app/dto/RoundScoreDto.java`
- `src/main/resources/templates/round-score/round-score-main.html`

## Arrangement

N/A


## Act

- Submit the task and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions


## Testing

- Update database configuration in application.properties to make it compatible with your local environment
- Build the application with the command: `mvn clean install`
- Launch the application with the command: `mvn spring-boot:run`
- Send  _ /round-score _  request with HTTP header  _ "Accept: text/csv" _  

```bash
curl -i -u 1:1 --header 'accept: text/csv' http://localhost:8082/round-score
```

        
- Verify the response headers and body contains CSV response like the given below:

```
HTTP status code: 200
Content-Type: text/csv;charset=UTF-8
```

```csv
Id,Date,Player,HCP,Competition,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,Stroke,Penalty,GrossScore,NetScore,NetScorePar,Stableford
37,2024-04-01,LAGERLÖF Ögge,36.0,2024,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,81,0,81,45,-27,63
49,2024-04-14,TALKACHOVA Palina,5.0,may,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,90,0,90,85,13,23
69,2024-03-03,ZHUK Aliaksandr,17.0,third,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,33,84,0,84,67,-5,67
70,2024-03-03,ZHUK Aliaksandr,17.0,third,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,333,384,0,384,367,295,67
71,2024-03-03,AGARWALLA Anjali,24.0,third,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,90,0,90,66,-6,42
```

        
- Add results of the manual tests to output.md. See (testing-template.md)[testing-template.md]

## Assertion

The generated solution is asserted against the criteria given below:


- **completeness** (==high==)
    - (==high==) Make sure that GET endpoint producing "text/csv" is added.
    - (==medium==) Make sure the CHANGES preserves the default RoundScoreController GET endpoint producing all media types other than "text/csv".
- **completeness** (==high==)
    - (==high==) Make sure the application returns round scores in CSV format in response to a request that accepts text/csv.
    - (==high==) Ensure the produced CSV has headers corresponding to scorecardsTable fields in the round-score-main.html.
    - (==high==) Make sure that null values ​​are represented as empty strings.
    - (==high==) Make sure the data field containing the comma is enclosed in double quotes.
    - (==high==) Make sure that the double quote contained in the data field is escaped by doubling it.
    - (==high==) Make sure that the CVS text is encoded with proper charset and not garbled
- **completeness** (==high==)
    - (==low==) Ensure the CHANGED code allows to convert collection of RoundScore to CSV format.
    - (==high==) Make sure the CHANGES utilizes Spring HTTP Message Conversion to convert domain object to "text/csv" MediaType.
- **completeness** (==high==)
    - (==high==) Make sure the CHANGES supposes a proven CSV processing library to write CSV.
- **completeness** (==medium==)
    - (==high==) Make sure that the application is built without errors.
    - (==high==) Make sure that the application is launched without errors.
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

N/A
