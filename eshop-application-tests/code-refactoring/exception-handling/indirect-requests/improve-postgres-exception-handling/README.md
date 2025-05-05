# Improve PostgreSQL exception handling

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/OrderProcessor/Services/GracePeriodManagerService.cs**
- Open the chat AI interface and enter:

```text
Improve exception handling in method `GetConfirmedGracePeriodOrders`: add handling for `PostgresException` and make logged errors more detailed.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **improve-postgres-exception-handling.patch** to project root folder and open PowerShell there. Run command **git apply ./improve-postgres-exception-handling.patch**
- Ensure you have **docker** installed on your machine
- Navigate to **/tests/Ordering.IntegrationTests** and open PowerShell there. Run command **dotnet test --filter TestCategory=GracePeriodManagerServiceTests**. Observe **Test summary: total: 2, failed: 0, succeeded: 2** in the bottom of the output.

See **GetConfirmedGracePeriodOrders_correct.cs** for the expected implementation of the only function that should be changed by the AI.
