# Generate redirect service unit tests

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

<details>
<summary>Chat IDE:</summary>

- Open the file **src/Identity.API/Services/RedirectService.cs**
- Open the chat AI interface and enter:

```text
Method `ExtractRedirectUriFromReturnUrl` inappropriately extracts a redirect URL and blindly returns any extracted return URL with very basic transformation, presenting a major security breach. Address these problems using native ASP.NET Core URL handling and applying best practices based on whitelisted URIs.
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

- Observe **Test summary: total: 10, failed: 0, succeeded: 10** in the bottom of the output
- Open **/src/Identity.API/Program.cs** in Visual Studio, add the following line above **app.MapDefaultControllerRoute();** and save the file

```C#
app.MapGet("/api/extract-redirect", (IRedirectService redirectService, [FromQuery] string url) => redirectService.ExtractRedirectUriFromReturnUrl(url));
```

- Ensure the start-up project is set to **eShop.AppHost**
- Press F5 to start the programme (the whole programme, not just the Identity.API project)
- Copy **validator.py** to **/src/Identity.API/**, open that folder in PowerShell and execute **validator.py**. Observe that the validator returns **Validation passed**. *Note: the validator will run an integration test against the modified service to ensure that it actually uses the whitelisted URLs added to settings.*

See the files in the **/solution** folder for the expected implementation.
