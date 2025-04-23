**Migrate to REST Controller Test**

*Test Description:*

A developer is trying to migrate a controller to a REST controller for handling calls from the frontend service.

*Act:*

<details>
<summary>Code Completion Instructions:</summary>

- Open the project `solution-migration/rest-controller/java`.
- Open the `PlayerController` class.
- Remove the following code:

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
```

- Add the following import statement to the `PlayerController` class:

```java
import org.springframework.http.*;
```

- Remove the following annotation:

```java
@Controller
```

- Add the following annotation to the `PlayerController` class:

```java
@RestController
```

- Remove the following code:

```java
private static final String PLAYER_MAIN_PAGE = "player/player-main";
private static final String PLAYER_ADD_PAGE = "player/player-add";
private static final String PLAYER_DETAILS_PAGE = "player/player-details";
private static final String PLAYER_ATTRIBUTE = "player";
private static final String PLAYERS_ATTRIBUTE = "players";
private static final String REDIRECT_TO_PLAYER = "redirect:/player";
```

- Comment out the method implementation in the `PlayerController` class.
- Move the cursor to the end of the `PlayerController` class.
- Accept a sequence of suggestions using the TAB and ENTER keys.
</details>

*Assert Conditions:*
- The code must compile.
- Copy the `PlayerControllerTest.java` file to the `solution-migration/rest-controller/java/src/test/java` folder.
- Run tests in the `PlayerControllerTest` class. All tests must pass successfully.

*Additional Note:* The correct solution is in the `correctResponse.txt` file.