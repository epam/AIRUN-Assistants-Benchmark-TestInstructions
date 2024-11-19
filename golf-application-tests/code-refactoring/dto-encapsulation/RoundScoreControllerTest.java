package com.golf.app.controller;

import com.golf.app.dto.RoundScoreDto;
import com.golf.app.model.Competition;
import com.golf.app.model.Player;
import com.golf.app.model.Round;
import com.golf.app.service.CompetitionService;
import com.golf.app.service.PlayerService;
import com.golf.app.service.RoundService;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.List;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoundScoreControllerTest {

    @Mock
    private PlayerService playerService;
    @Mock
    private CompetitionService competitionService;
    @Mock
    private RoundService roundService;
    @Mock
    private Model model;

    @InjectMocks
    private RoundScoreController roundScoreController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDisplayScoreCardInputPage() {
        List<Player> players = Arrays.asList(new Player());
        List<Competition> competitions = Arrays.asList(new Competition());
        List<Round> rounds = Arrays.asList(new Round());

        Mockito.when(playerService.getAllPlayers()).thenReturn(players);
        Mockito.when(competitionService.getAllCompetition()).thenReturn(competitions);
        Mockito.when(roundService.getAllRound()).thenReturn(rounds);

        String actualViewName = roundScoreController.displayScoreCardInputPage(model);

        Mockito.verify(playerService).getAllPlayers();
        Mockito.verify(competitionService).getAllCompetition();
        Mockito.verify(roundService).getAllRound();
        ArgumentCaptor<RoundScoreDto> roundScoreDtoCaptor = ArgumentCaptor.forClass(RoundScoreDto.class);
        Mockito.verify(model).addAttribute(ArgumentMatchers.eq("roundScoreDto"), roundScoreDtoCaptor.capture());
        RoundScoreDto capturedRoundScoreDto = roundScoreDtoCaptor.getValue();
        assertEquals(players, capturedRoundScoreDto.getPlayers());
        assertEquals(competitions, capturedRoundScoreDto.getCompetitions());
        assertEquals(rounds, capturedRoundScoreDto.getRounds());
        assertNotNull(capturedRoundScoreDto.getCompetitionRounds());
        assertNotNull(capturedRoundScoreDto.getRoundPlayers());
        Mockito.verify(model, Mockito.times(1)).addAttribute(ArgumentMatchers.any(),
            ArgumentMatchers.any());
        assertEquals("round-score/round-score-input-page", actualViewName);
    }
}
