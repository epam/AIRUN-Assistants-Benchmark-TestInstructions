# Implement primary constructors in the Ordering.API project

## Act

- Open the eShop application:
<https://github.com/AlexanderTarvid/eShop-250408>

- Close any open files
- Open the agent interface and enter:

```text
In the Ordering.API project, change all files where primary constructors aren't used. Where possible, remove private fields set by the primary constructor. Where a primary constructor is already used but private fields set by it aren't removed, remove them if possible. Your solution must not change the functionality.

The solution must build without errors. Ensure that your solution is efficient.
```

- Submit the request
- Wait until the agent finishes working, accepting requests to continue working (if requested) and requests to run external tools (e.g., PowerShell commands)
- Accept all changes

</details>

## Assert

### Solution Necessity

55

### Solution Sufficiency

- Copy **implement-primary-constructors.patch** file to the solution root
- Open PowerShell and run **git apply ./implement-primar-constructors.patch**
- Run **cd ./src/Ordering.API && dotnet build** and observe that there are no build errors (note: IDE0290 errors are enforced by the patch, they are directly relevant to this task)
