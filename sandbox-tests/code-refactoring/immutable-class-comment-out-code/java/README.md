**Immutable Class Test**

*Test Description:*

A developer is attempting to refactor a class to make it immutable.

*Act:*

<details> 
<summary>Code Completion Instructions:</summary>

- Open the project `code-refactoring/immutable-class/java`.
- Open the `Player` class.
- Add the following import statement to the `Player` class:

```java
import lombok.Value;
```
  
- Comment out the inner implementation of the `Player` class.
- Move the cursor to before the `Player` class definition.
- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
- Move the cursor to the end of the `Player` class.
- Wait for the suggestion.
- Accept a sequence of suggestions using the TAB and ENTER keys.
</details>

*Assert Conditions:*
- The code must compile.

*Additional Note:* The correct solution is in the `correctResponse.txt` file.