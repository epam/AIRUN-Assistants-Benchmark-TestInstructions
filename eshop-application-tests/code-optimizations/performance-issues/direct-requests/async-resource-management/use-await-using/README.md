# Use await using instead of using in asynchronous methods

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/OrderProcessor/Services/GracePeriodManagerService.cs**
- Open the chat AI interface and enter:

```text
Use `await using` in all async methods of the current file.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **validator.py** and **validator_utils.py** to **src/OrderProcessor/Services/**, open that folder in PowerShell and execute **validator.py**. Observe that the validator returns **Validation passed**.

See **GetConfirmedGracePeriodOrders_correct.cs** for the expected implementation of the only function that should be changed by the AI.
