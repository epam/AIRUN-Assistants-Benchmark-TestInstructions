# Extract common code from methods

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/Ordering.API/Apis/OrdersApi.cs**
- Open the chat AI interface and enter:

```text
Refactor `CancelOrderAsync` and `ShipOrderAsync`. Extract as much as possible of the code common to these methods to a private method `ShipOrCancelOrderAsync`. Rewrite the two methods to call `ShipOrCancelOrderAsync` and otherwise contain only unsharable code.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **extract-common-code-from-methods.patch** to project root folder and open PowerShell there. Run command **git apply ./extract-common-code-from-methods.patch**
- Ensure you have **docker** installed on your machine
- Navigate to **/tests/Ordering.UnitTests** and open PowerShell there. Run command **dotnet test --filter TestCategory=OrdersApiTests**. Observe **Test summary: total: 10, failed: 0, succeeded: 2** in the bottom of the output.

See **OrdersApi_correct.cs** for the expected implementation of the only functions that should be changed by the AI.
