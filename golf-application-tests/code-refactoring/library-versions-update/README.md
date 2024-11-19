**Library versions updating test**

*Act*

- Open the Golf application project:
https://github.com/PolinaTolkachova/golf-application

<details>
<summary>Chat IDE:</summary>

- Go to file src/test/pom.xml
- Highlight the file
- Open the chat AI interface and enter:

> Update the libraries in `pom.xml` to the latest version using Maven repository. Check the latest version at https://mvnrepository.com

- Submit the question
- Replace the existing code with the proposed code
- The code should compile

</details>

<details>
<summary>Developer Agent:</summary>

- Open the developer agent interface
- Add files to context:
    - src/test/pom.xml
- Enter task description:

> Update the libraries in `pom.xml` to the latest version using Maven repository. Check the latest version at https://mvnrepository.com

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

</details>

*Assert conditions*

- Libraries must be updated to the latest versions
- Check the latest versions of the libraries using the links:
https://mvnrepository.com/artifact/org.springframework.security/spring-security-test
https://mvnrepository.com/artifact/org.projectlombok/lombok
https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
https://mvnrepository.com/artifact/io.springfox/springfox-swagger2
https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
https://mvnrepository.com/artifact/org.modelmapper/modelmapper


