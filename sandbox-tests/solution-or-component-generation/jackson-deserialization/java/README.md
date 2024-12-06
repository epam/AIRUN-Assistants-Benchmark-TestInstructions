**Configure Jackson Object Mapper Deserialization in Spring Boot project**

*Test Description*:

A developer is trying to configure Jackson Object Mapper Deserialization in Spring Boot project

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/spring-boot/java
- Open the JacksonConfig class
- Type in the class body and press Enter

```java
// configure Jackson to fail on unknown properties and accept float as int
```

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
- Build the project with the command `gradle build` and verify no errors reported
- Run the application with the command `gradle bootRun`
- Verify the generated mapping methods
    - create an item with the request:

```bash
curl -d "{\"name\":\"nameX1\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/items
```

    - expected output:

```json
{"id":1,"name":"nameX1"}
```

    - try to create an item with unknown property:

```bash
curl -v -d "{\"name\":\"nameX2\",\"fieldX\":\"valueX2\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/items
```

    - verify an error is returned

```
< HTTP/1.1 400
<
{"timestamp":1733503903833,"status":400,"error":"Bad Request","path":"/api/items"}
``

*Additional note*

An example of solution is in the correctResponse.txt file