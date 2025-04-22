**Maven to Gradle migration test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to file src/test/pom.xml
- Highlight the code
- Open the chat AI interface and enter:

```
Convert the Maven POM file to a Gradle build file
```

- Submit the question

</details>

*Assert conditions*

- The library versions should be added and match the versions specified in the src/test/pom.xml file
- The build.gradle should contain at least the code specified in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file