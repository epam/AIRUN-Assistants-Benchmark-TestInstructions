***Query database using JPQL in Spring Boot project**

*Test Description*:

A developer is trying to Query database using JPQL in Spring Boot project

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/spring-boot/java
- Open the ItemRepository interface
- Type in the interface body and press Enter

```java
// search for items that have been expired by now
```

- Accept the best suggested implementation using the TAB and ENTER keys
- *Optional*: Add the line with `@Query` annotation after the comment if correct implementation is not proposed. Invoke code generation and accept suggestion
- Add all necessary imports
- Open ItemService class
- Go to `findExpiredByNow` method
- Remove line with `return` statement
- Move cursor to the end of TODO comment and press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Add all necessary imports

</details>

*Extra edits*
- Open the ItemResource class
- Copy and paste the following method in the class

```java
@PostMapping
public ResponseEntity<ItemDTO> createItem(@RequestBody @Valid final ItemDTO itemDTO) {
    Item item = itemService.create(convertToEntity(itemDTO));
    return new ResponseEntity<>(convertToDto(item), HttpStatus.CREATED);
}
```

*Assert conditions*

- Code must compile
- Copy JpqlTest.java to the solution-or-component-generation/spring-boot/java/src/test/java/com/epam/aicode/springpr directory
- Build the project with the command `gradle build` and verify no errors reported
- Check if the application run successfully with the command `gradle bootRun`

*Additional note*

An example of solution is in the correctResponse\*.txt files