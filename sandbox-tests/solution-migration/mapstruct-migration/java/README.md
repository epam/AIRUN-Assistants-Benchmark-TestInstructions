**Mapstruct migration test**

*Test Description*
A developer is trying to apply Mapstruct mapper processor to map one Java object to another

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-migration/mapstruct-migration/java
- Open the EmployeeMapperMapstruct class
- Add the suggested method to the EmployeeMapperMapstruct class
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/mapstruct-migration/java
- Open the EmployeeMapperMapstruct class
- Type in the chat window:

> Implement the employeeDTOToEmployee method in the EmployeeMapperMapstruct class using MapStruct library and Mapping annotation

- Add the suggested method to the EmployeeMapperMapstruct class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the EmployeeMapperMapstructTest.java file to the solution-migration/mapstruct-migration/java/src/test/java folder
- Run tests in the EmployeeMapperMapstructTest class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file