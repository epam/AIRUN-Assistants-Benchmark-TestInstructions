**Generate Rest Controller Request Mappings**

*Test Description*:

A developer is trying to implement Rest Controller Request Mappings methods

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/spring-boot/java
- Open the ItemService class and scroll it from top till bottom
- Open the ItemResource class and scroll it from top till bottom
- Move cursor to the line before private methods
- Type `@GetMapping("/{id}")` and press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Type `@PostMapping` and press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Type `@PutMapping("/{id}")` and press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Type `@DeleteMapping("/{id}")` and press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy ItemResourceTest.java to the solution-or-component-generation/spring-boot/java/src/test/java/com/epam/aicode/springpr directory
- Build the project with the command `gradle build` and verify no errors reported
- Check if the application run successfully with the command `gradle bootRun`

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file