# Generate redirect service unit tests

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- - Copy **generate-redirect-service-unit-tests.patch** to project root folder and open PowerShell there. Run command **git apply ./generate-redirect-service-unit-tests.patch**
- Open files **src/Identity.API/Services/RedirectService.cs** and **tests/Identity.UnitTests/RedirectServiceTests.cs**
- Open the chat AI interface and enter:

```text
Generate unit tests for `RedirectService` in `RedirectServiceTests` using MSTest framework. Achieve full coverage.
```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Navigate to **/tests/Identity.UnitTests** and open PowerShell there. Run command

```pwsh
 dotnet test --filter TestCategory=RedirectServiceTests --collect:"XPlat Code Coverage"; Move-Item -Path .\TestResults\*\coverage.cobertura.xml -Destination .\coverage.cobertura.xml -Force
```

- Observe **Test summary: total: *n*, failed: 0, succeeded: *n*** in the bottom of the output, where *n* is some number.
- Copy **coverage-validator.py** to **/tests/Identity.UnitTests**. In the same PowerShell window as previously, run **coverage-validator.py**. Observe that the validator returns **Validation passed**.

See **RedirectServiceTests_correct.cs** for the expected implementation.
