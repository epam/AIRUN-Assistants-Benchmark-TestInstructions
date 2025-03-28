**HTTP basic authentication test**

*Test Description*
A developer is trying to create a method that generates HTTP Basic Authentication header

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project solution-or-component-generation/http-basic-auth/C#
- Open the HttpAuth class
- Add the suggested method to the HttpAuth class
- Add all necessary imports

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/http-basic-auth/C# in IDE
- Open the HttpAuth class
- Type in the class:

```C#
public string CreateBasicAuthenticationHeader(string username, string password) {
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys
- Add all necessary imports

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project solution-or-component-generation/http-basic-auth/C#
- Open the HttpAuth class
- Type in the chat window:

```
Implement the CreateBasicAuthenticationHeader(string username, string password) method that returns the HTTP basic authentication header
```

- Add the suggested method to the HttpAuth class
- Add all necessary imports

</details>

*Assert conditions*

- Code must compile
- Copy the BasicAuthTests.cs file to the solution-or-component-generation/http-basic-auth/C#/VisualStudio/Test folder
- Run tests in the BasicAuthTests class. Tests must pass successfully

*Additional note*

The correct solutions is in the correctResponse.txt file