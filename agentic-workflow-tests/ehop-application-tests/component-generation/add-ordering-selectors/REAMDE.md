# Add buttons to the website to enable ordering by name and by price

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

- Close any open files
- Open the agent interface and enter:

```text
Observe the webpage with products. To the left of products, there is a column with Brand and Type selections. Above these selections in the same column, add another selection. It should be named Ordering and have two selection buttons: `Name (A-Z)` and `Price (Asc)`. Use the same styling as for Brand and Type. By default, `Name (A-Z)` should be on and show products ordered by name. By clicking on `Price (Asc)`, that option should be turned on instead and the products should be reordered ascending by price. Ensure consistency between how filtering for brand and type is implemented and the new implementation of choosing an ordering. Changing the selection for Ordering should not change the existing selection for Brand and Type.

The solution must build without errors. Ensure that your solution is efficient.
```

- Submit the request
- Wait until the agent finishes working, accepting requests to continue working (if requested) and requests to run external tools (e.g., PowerShell commands)
- Accept all changes

</details>

## Assert

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
