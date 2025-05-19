# Enable nullable references in an easy project

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

- Open file **/src/Ordering.API/Ordering.API.csproj**
- Open the agent interface and enter:

```text
Project Ordering.API has a complex nested folder structure. While it targets .NET 9, it does not enable nullable references. Even if they are enabled, the project needs substantial refactoring to remove compiler errors and warnings.

Do the following:

1. Enable nullable references in the project
2. Sequentially go over all project's files and modify the code to fix compiler errors and warnings related to enabling nullable references. 
3. Analyze all files inside the project and remove any null checks that became redundant after enabling nullable references.
4. Identify tests that test the project and run all these tests

Follow these key requirements:
- The project should build without errors
- Do not modify tests
- All tests should execute successfully
- Adhere to best practices
```

- Submit the request
- Wait until the agent finishes working, accepting requests to continue working (if requested) and requests to run external tools (e.g., PowerShell commands)
- Accept all changes

## Assert

- Open the solution in Visual Studio, run solution build and ensure that there are no errors *(if there are, score 0)*
- Open Test Explorer, run **Ordering.FunctionalTests** and **Ordering.UnitTests** and ensure all tests run successfully *(if not, score 0)*
- Open a new window in the same or another **(?)** agent, enter the following prompt and observe the verdict

```text
Perform a comprehensive analysis of `Ordering.API` project. Do not consider other projects, focus on the requested project. Analyze the extent to which it follows best practices with respect to nullable reference handling. Score it on a 0-5 scale defined as follows:

0: Nullable context disabled (`<Nullable>disable</Nullable>`). No nullability annotations or compiler analysis.
1: Nullable context enabled (`<Nullable>enable</Nullable>`), but warnings suppressed globally (e.g., `.editorconfig` rules, `#nullable disable`). Minimal use of `?`/`!`.
2: Partial adoption: Some classes/methods use `?`/non-nullable types correctly, while others ignore annotations (e.g., `string` used for nullable values). Frequent suppressions (`!`, `#nullable disable`). Many unaddressed warnings.
3: Core code annotated (public APIs, critical paths). Suppressions limited to edge cases (e.g., reflection). Most warnings resolved.
4: Full annotations across the codebase. Suppressions rare and justified (e.g., interop). Compiler warnings near zero.
5: Zero warnings; no suppressions. Code adheres strictly to nullability rules (no `!`, full `?` coverage).
```

- Repeat the previous step (in a new window every time), so that there are 3 evaluation scores **(only three in GPT-4.1? or three in GPT-4.1 + three in Claude 3.7? or also add three in Gemini?)**
- The final score is the average of all evaluation scores
