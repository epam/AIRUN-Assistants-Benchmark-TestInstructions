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

Add a new product with a very long (max length as allowed by the database) multi-word title starting with 'Ab'.
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
  - The long-titled item appears on the webpage with the title shown completely, split across two lines without breaking words
  - Items having two-line titles have the whole title styled in the same way as items having one-line titles
  - Item "Adventurer GPS Watch" shows "Out of stock" in red exactly under the price aligned right
  - All other items show "In stock" in green exactly under the price aligned right irrespective of the length of the title
  - Click on "Adventurer GPS Watch", observe that on the product-specific page, "Out of stock" is shown in red between the price and the "Log in to purchase" button
  - Go back and click on any other item, observe that on the product-specific page, "In stock (100 units)" is shown in green between the price and the "Log in to purchase" button

### Notes

1. The color does not necessarily have to be exactly 'red' and exactly 'green'. It is acceptable if the color appears reddish or greeenish.

2. It is sufficient for the agent to change the following files:

    - /src/Catalog.API/Infrastructure/CatalogContextSeed.cs
    - /src/Catalog.API/Setup/catalog.json
    - /src/WebApp/Components/Pages/Item/ItemPage.razor
    - /src/WebApp/Components/Pages/Item/ItemPage.razor.css
    - /src/WebAppComponents/Catalog/CatalogItem.cs
    - /src/WebAppComponents/Catalog/CatalogListItem.razor
    - /src/WebAppComponents/Catalog/CatalogListItem.razor.css

3. Ideally, the agent should generate a picture for the new product:

    - src/Catalog.API/Pics/102.webp
