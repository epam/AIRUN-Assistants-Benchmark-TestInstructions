# Improve PostgreSQL exception handling

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/OrderProcessor/Services/GracePeriodManagerService.cs**
- Open the chat AI interface and enter:

```text
Improve exception handling in method `GetConfirmedGracePeriodOrders`. Catch both `NpgsqlException` and `PostgresException`, each in its single dedicated `catch` block. For `NpgsqlException`, use "General error loading confirmed grace period orders: {M}" as the main message, where `{M}` is the value of the `Message` property of the caught exception. For `PostgresException`, use "SQL error loading confirmed grace period orders: {M}", where `{M}` is the value of the `Message` property of the caught exception. If `Detail` property is available, append " Detail: {D}" to the main message, where `{D}` is the value of the `Detail` property. In both exception classes, if the exception wraps another exception, append " Root cause: {R}" to the logged message, where `{R}` is the value of the `Message` property of the wrapped exception object.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **improve-postgres-exception-handling.patch** to project root folder and open PowerShell there. Run command **git apply ./improve-postgres-exception-handling.patch**
- Navigate to **/tests/Ordering.UnitTests** and open PowerShell there. Run command **dotnet test --filter TestCategory=GracePeriodManagerServiceTests**. Observe **Test summary: total: 2, failed: 0, succeeded: 2** in the bottom of the output.

See **GetConfirmedGracePeriodOrders_correct.cs** for the expected implementation of the only function that should be changed by the AI.
