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

    - update the created item with the request:

```bash
curl -d "{\"id\":1,\"name\":\"nameX1updated\"}" -H "Content-Type: application/json" -X PUT http://localhost:8080/api/items/1
```

    - get the item with the request:

```bash
curl -s http://localhost:8080/api/items/1 | jq
```

    - expected output:

```json
{
  "id": 1,
  "name": "nameX1updated"
}
```

    - delete the item with the request:

```bash
curl -v -X DELETE http://localhost:8080/api/items/1
```

    - verify 204 code is returned:

```
< HTTP/1.1 204
```

    - get all items with the request:

```bash
curl http://localhost:8080/api/items
```

- expected output:

```json
[]
```

*Additional note*

An example of one of the possible solutions is in the correctResponse.txt file