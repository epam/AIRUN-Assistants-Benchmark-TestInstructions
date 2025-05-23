# Add stock information to product list and product pages

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

- Close any open files
- Open the agent interface and enter:

```text
Add information about the warehouse status of products.

On the webpage that lists the products, the status should appear directly below the price. The first line should contain the beginning of the product title on the left and its price on the right. The second line should contain the continuation of the product title (if available) and the warehouse status on the right. The status should show "In stock" in green or "Out of stock" in red. Ensure the title does not have words broken across lines.

On the webpage of a specific product, the status should be more detailed. It should show "In stock (x units)" in green or "Out of stock" in red. The status should appear to the right of the price but to the left of the purchase button, ensuring enough spacing for usability.

Modify Adventurer GPS Watch to have 0 items in stock in the initial database setup.

Add a new product with a very long (max length as allowed by the database) multi-word title starting with 'A'.
```

- Submit the request
- Wait until the agent finishes working, accepting requests to continue working (if requested) and requests to run external tools (e.g., PowerShell commands)
- Accept all changes

</details>

## Assert

- Ensure that all application-related containers were stopped and deleted (otherwise, the database will not be re-initialised with the new changes)
- Open the solution in Visual Studio, run solution build and ensure that there are no errors
- Ensure that **eShop.AppHost** is the startup project and run the solution
- In the Resources dashboard that open, click on the HTTPS link of **WebApp** and wait for products to show up
- Verify that:
  - The Ordering groups exists and appears directly above Brand, it includes **Name (A-Z)** and **Price (Asc)** entries, **Name (A-Z)** is toggled on and products are ordered by name
  - Select any specific brand and observe that **Name (A-Z)** is still on and products are still ordered by name
  - Click on **Price (Asc)** and observe that the brand selection remains the same, but products are now ordered by price
  - While **Price (Asc)** is on, continue to Page 2 and observe that products are still sorted by price and the lowest price is not lower than the highest price on Page 1
  - The styling of the Ordering group is consistent with Brand and Type

### Notes

1. It is sufficient for the agent to change the following files:

    - /src/Catalog.API/Apis/CatalogApi.cs
    - /src/WebApp/Components/Pages/Catalog/Catalog.razor
    - /src/WebAppComponents/Catalog/CatalogSearch.razor
    - /src/WebAppComponents/Services/CatalogService.cs
    - /src/WebAppComponents/Services/ICatalogService.cs

    The following files might also need to be modified (modifying the hybrid app was not directly requested, so not modifying these should not be considered a drawback, unless it results in a build error):

    - /src/HybridApp/Services/CatalogService.cs
    - /src/HybridApp/Components/Pages/Catalog/Catalog.razor
    - /src/HybridApp/Components/Pages/Catalog/CatalogSearcj.razor

2. The agent might propose a solution without modifying the API, using an inefficient workaround. This should be considered as a violation of the direct request for an efficient solution.
