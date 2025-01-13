package com.epam.aicode.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setId(1L);
        player.setName("testName");
        player.setSurname("testSurname");
    }

    @Test
    void testGetPlayers() {
        when(playerService.getAllPlayers()).thenReturn(Arrays.asList(player));

        ResponseEntity<List<Player>> response = playerController.getPlayers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(playerService, times(1)).getAllPlayers();
    }

    @Test
    void testAddPlayer() {
        when(playerService.savePlayer(any(Player.class))).thenReturn(player);

        ResponseEntity<Player> response = playerController.addPlayer(player);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(player, response.getBody());
        verify(playerService, times(1)).savePlayer(any(Player.class));
    }

    @Test
    void testGetPlayerById() {
        when(playerService.getPlayerById(1L)).thenReturn(Optional.of(player));

        ResponseEntity<Player> response = playerController.getPlayerById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(player, response.getBody());
        verify(playerService, times(1)).getPlayerById(anyLong());
    }

    @Test
    void testUpdatePlayer() {
        when(playerService.savePlayer(any(Player.class))).thenReturn(player);

        ResponseEntity<Player> response = playerController.updatePlayer(1L, player);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(player, response.getBody());
        verify(playerService, times(1)).savePlayer(any(Player.class));
    }

    @Test
    void testDeletePlayer() {
        when(playerService.getPlayerById(1L)).thenReturn(Optional.of(player));
        doNothing().when(playerService).deletePlayer(1L);

        ResponseEntity<Void> response = playerController.deletePlayer(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(playerService, times(1)).deletePlayer(anyLong());
    }

    @Test
    void testGetPlayerById_NotFound() {
        when(playerService.getPlayerById(1L)).thenReturn(Optional.empty());

        try {
            playerController.getPlayerById(1L);
        } catch (PlayerNotFoundException ex) {
            assertEquals("Player by ID not found", ex.getMessage());
        }

        verify(playerService, times(1)).getPlayerById(anyLong());
    }

    @Test
    void testDeletePlayer_NotFound() {
        when(playerService.getPlayerById(1L)).thenReturn(Optional.empty());

        try {
            playerController.deletePlayer(1L);
        } catch (PlayerNotFoundException ex) {
            assertEquals("Player by ID not found", ex.getMessage());
        }

        verify(playerService, times(1)).getPlayerById(anyLong());
    }
}