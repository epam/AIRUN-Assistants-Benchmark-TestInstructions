**Immutable Class Test**

*Test Description:*

A developer is attempting to refactor a class to make it immutable.

*Act:*

<details> 
<summary>Bare LLM Testing Instructions:</summary>

- Open the `prompt.txt` file.
- Copy a question located in the `prompt.txt` file to the chat window.
- Submit the question.
- Open the project `code-refactoring/immutable-class/java`.
- Open the `Player` class.
- Change the class implementation to the suggested implementation.
- Add all necessary imports.
</details>

<details> 
<summary>Code Completion Instructions:</summary>

- Open the project `code-refactoring/immutable-class/java`.
- Open the `Player` class.
- Add the following import statement to the `Player` class:

```java
import lombok.Value;
```

- Remove the inner implementation of the `Player` class.
- Move the cursor to before the `Player` class definition.
- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
- Move the cursor to the beginning of the inner implementation of the `Player` class.
- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
</details>

<details> 
<summary>Chat IDE:</summary>

- Open the project `code-refactoring/immutable-class/java`.
- Open the `Player` class.
- Type the following in the chat window:

```
Rewrite the class to make it immutable using Lombok annotations
```

- Change the class implementation to the suggested implementation.
- Add all necessary imports.
</details>

*Assert Conditions:*
- The code must compile.

*Additional Note:* The correct solution is in the `correctResponse.txt` file.