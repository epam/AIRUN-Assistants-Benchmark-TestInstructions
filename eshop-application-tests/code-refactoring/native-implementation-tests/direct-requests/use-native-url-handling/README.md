# Generate redirect service unit tests

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open the file **src/Identity.API/Services/RedirectService.cs**
- Open the chat AI interface and enter:

```text

```

- Submit the request
- Accept the suggestions
- Save the file

</details>

## Assert

- There are no compiler errors
- Copy **use-native-url-handling.patch** to project root folder and open PowerShell there. Run command **git apply ./use-native-url-handling.patch**
- Navigate to **/tests/Identity.UnitTests** and open PowerShell there. Run command

```pwsh
 dotnet test --filter TestCategory=RedirectServiceTests --collect:"XPlat Code Coverage"; Move-Item -Path .\TestResults\*\coverage.cobertura.xml -Destination .\coverage.cobertura.xml -Force
```

- Observe **Test summary: total: 8, failed: 0, succeeded: 8** in the bottom of the output.

See **RedirectService_correct.cs** for the expected implementation.
