# Generate redirect service unit tests

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open the file **src/Identity.API/Services/RedirectService.cs**
- Open the chat AI interface and enter:

```text
Refactor `ExtractRedirectUriFromReturnUrl`. Use native ASP.NET Core URL handling. Inject a hash set with whitelisted URIs into the service. Return the whole redirect URI if it is a valid whitelisted URI. If multiple return URIs are supplied, consider only the first one. Handle potential errors gracefully, returning an empty string. Do not use namespace prefixes in code. Do not modify any other files.
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
 dotnet test --filter TestCategory=RedirectServiceSecurityTests
```

- Observe **Test summary: total: 10, failed: 0, succeeded: 10** in the bottom of the output.

See **RedirectService_correct.cs** for the expected implementation.
