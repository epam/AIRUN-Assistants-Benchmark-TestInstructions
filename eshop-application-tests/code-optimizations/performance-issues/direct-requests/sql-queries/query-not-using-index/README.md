# Rewriting an SQL query to ensure that column indexes are used

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open file **src/OrderProcessor/Services/GracePeriodManagerService.cs**
- Open the chat AI interface and enter:

```text
The `ordering.orders` table has indexes on `OrderDate` and `OrderStatus` columns. Please rewrite the SQL query to ensure that these indexes are used.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- Only the SQL query code is modified
- Copy **validator.py** and **correctResponses.txt** to **src/OrderProcessor/Services/**, open that folder in PowerShell and execute **validator.py**. Observe that the validator returns **Validation passed**.
