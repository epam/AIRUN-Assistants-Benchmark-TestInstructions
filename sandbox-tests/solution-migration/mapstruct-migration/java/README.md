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
- Open the EmployeeMapperMapstruct interface
- Add the suggested method to the EmployeeMapperMapstruct interface
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-migration/mapstruct-migration/java in IDE
- Open the Employee class and scroll through the code
- Open the EmployeeDTO class and scroll through the code
- Open the EmployeeMapperMapstruct interface
- Press ENTER in the interface body
- Accept one from the suggestions using the TAB and ENTER keys
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-migration/mapstruct-migration/java in IDE
- Open the Employee class and scroll through the code
- Open the EmployeeDTO class and scroll through the code
- Open the EmployeeMapperMapstruct interface
- Type in the chat window:

```
Declare method converting Employee object to EmployeeDTO object in the EmployeeMapperMapstruct interface using MapStruct library
```

- Add the suggested method to the EmployeeMapperMapstruct interface
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the EmployeeMapperMapstructTest.java file to the solution-migration/mapstruct-migration/java/src/test/java folder
- Run tests in the EmployeeMapperMapstructTest class. Tests must pass successfully

*Additional note*

The correct solution is in the correctResponse.txt file. The code must declare explicit mapping from email to eMail as the field names are different in the classes and MapStruct cannot automatically do the mapping. On the contrary MapStruct automatically maps id and name fields and explicit mappings are not required since the fields have identical names in both classes.
