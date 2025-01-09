**0010. Fix an issue with hardcoded player photo id in Golf application**

*Act*

- Open the Golf application project from the repository https://github.com/PolinaTolkachova/golf-application 

- Open the developer agent interface
- Add files to context if the agent doesn't support auto-discovering of relevant source code:
    - src/main/java/com/golf/app/model/Player.java
    - src/main/java/com/golf/app/model/PlayerPhoto.java
    - src/main/java/com/golf/app/dto/PlayerPhotoDto.java
    - src/main/java/com/golf/app/controller/PlayerController.java
    - src/main/java/com/golf/app/controller/PlayerPhotoController.java
    - src/main/java/com/golf/app/service/PlayerPhotoService.java
    - src/main/java/com/golf/app/service/PlayerPhotoServiceImpl.java
    - src/main/resources/templates/player/player-details.html
- Enter task description:

```
Fix the issue given below.

# Other player photo is shown for a player with missing photo

## Description
Other player photo is shown on the page of a player with missing photo.

## Steps to reproduce

0. PlayerPhoto entity with id 1L must exist in database.
1. Add a new player without photo.
2. Visit the added player page, for instance http://localhost:8082/player/2

## Actual results
- Image from PlayerPhoto entity with id 1L is showed on the page

## Expected results
- A photo placeholder explicitly indicating a missing photo is shown on the page

## Fix acceptance criteria
- A photo with hardcoded id 1L should not be shown on a page of player with missing photo
- A photo placeholder should be shown instead of missing photo on player page
- A new player should be added without photo
```

- Submit the task description and wait implementation plan is generated
- Go to the implementation plan
- Follow the implementation plan steps and modify source code following the instructions

*Assertion*

<details>
<summary>Manual Assertion:</summary>

- Make sure, the following changes suggested in src/main/java/com/golf/app/controller/PlayerController.java:
    - line `player.setPhotoId(1L);` removed from the method `addPlayer`
    - the method `displayPlayerDetailsPage` is changed to proper handle missing player photo:

```java
    @GetMapping("/{id}")
    public String displayPlayerDetailsPage(@PathVariable("id") Long id, Model model) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player by ID not found"));

        PlayerPhotoDto playerPhotoDto = null;

        if (player.getPhotoId() != null) {
            Optional<PlayerPhoto> playerPhoto = playerPhotoService.findPlayerPhotoById(player.getPhotoId());
            if (playerPhoto.isPresent()) {
                playerPhotoDto = new PlayerPhotoDto(playerPhoto.get().getId(), playerPhoto.get().getName(),
                        Base64.getEncoder().encodeToString(playerPhoto.get().getData()));
            }
        }

        model.addAttribute(PLAYER_ATTRIBUTE, player);
        model.addAttribute(PLAYER_PHOTO_DTO_ATTRIBUTE, playerPhotoDto);
        return PLAYER_DETAILS_PAGE;
    }
```

- code to show player photo in `src/main/resources/templates/player/player-details.html` is changed to show placeholder image when no photo is available:

```html
    <img th:if="${playerPhotoDto != null}" th:src="|data:scoreCardImage/jpeg;base64,${playerPhotoDto.base64Data}|" alt="Player Photo" style="width: 300px; height: auto; margin: 10px;"/>
    <img th:if="${playerPhotoDto == null}" src="/images/no-photo-available.png" alt="No Photo Available" style="width: 300px; height: auto; margin: 10px;"/>
```

-  a photo placeholder image is created in src/main/resources/static/images/

</details>

<details>
<summary>Automated LLM Assertion:</summary>

Make evaluation following steps described in [auto-llm-eval README](../auto-llm-eval/README.md).

</details>
