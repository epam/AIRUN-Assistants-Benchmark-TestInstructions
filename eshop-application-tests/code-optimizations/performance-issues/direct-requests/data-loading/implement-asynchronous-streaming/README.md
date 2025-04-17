# Implement asynchronous streaming of data from the database instead of bulk loading

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/OrderProcessor/Services/GracePeriodManagerService.cs**
- Open the chat AI interface and enter:

```text
Please create method `StreamConfirmedGracePeriodOrders` implementing asynchronous streaming instead of `GetConfirmedGracePeriodOrders`. Do not introduce cancellation tokens.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **validator.py** and **validator_utils.py** to **src/OrderProcessor/Services/**, open that folder in PowerShell and execute **validator.py**. Observe that the validator returns **Validation passed**.

The **\*.cs** files with the expected implementation of the two functions that should be added or modified by AI are included here for reference.
