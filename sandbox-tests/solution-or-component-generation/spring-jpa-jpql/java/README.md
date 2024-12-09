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
- Add all necessary imports
- Open ItemService class
- Go to `findExprireByNow` method
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
- Build the project with the command `gradle build` and verify no errors reported
- Run the application with the command `gradle bootRun`
- Verify the generated mapping methods
    - create non-expired item with the request:

```bash
curl -d "{\"name\":\"nameX1\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/items
```

    - expected output:

```json
{"id":1,"name":"nameX1"}
```

    - create an expired item with the request:

```bash
curl -d "{\"name\":\"nameX2\",\"expiredAfter\":\"2023-03-25T00:00:00\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/items
```

    - expected output:

```json
{"id":2,"name":"nameX2","expiredAfter":"2023-03-25T00:00:00"}
```

    - get all expired items with the request:

```bash
curl -s http://localhost:8080/api/items/:expired | jq
```

    - expected output:

```json
[
  {
    "id": 2,
    "name": "nameX2",
    "expiredAfter": "2023-03-25T00:00:00"
  }
]
```

*Additional note*

An example of solution is in the correctResponse.txt file