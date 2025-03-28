**Docker compose file generation test**

*Test Description*
A developer is trying to generate a docker compose file that defines a web application and a database

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project devops/docker-compose/java

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project devops/docker-compose/java
- Open the docker-compose.yml file
- Type in the chat window:

```
Generate a docker-compose.yml file that defines two services: a web application (web) and a postgres database (db)
```

</details>

*Assert conditions*

Compare the generated implementation with the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file