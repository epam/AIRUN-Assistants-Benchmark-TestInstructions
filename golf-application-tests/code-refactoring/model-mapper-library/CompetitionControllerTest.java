package com.golf.app.controller;

import com.golf.app.dto.RoundDto;
import com.golf.app.exception.CompetitionNotFoundException;
import com.golf.app.model.Competition;
import com.golf.app.model.Round;
import com.golf.app.service.CompetitionService;
import com.golf.app.service.CourseService;
import com.golf.app.service.PlayerService;
import com.golf.app.service.RoundService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CompetitionControllerTest {

    @Mock
    private CompetitionService competitionService;
    @Mock
    private RoundService roundService;
    @Mock
    private PlayerService playerService;
    @Mock
    private CourseService courseService;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CompetitionController competitionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCompetitionRounds() {
        Long competitionId = 1L;
        Competition competition = new Competition();
        competition.setId(competitionId);

        Round round1 = new Round();
        round1.setId(1L);
        Round round2 = new Round();
        round2.setId(2L);

        List<Round> rounds = Arrays.asList(round1, round2);
        competition.setRounds(rounds);

        RoundDto roundDto1 = new RoundDto();
        roundDto1.setId(1L);
        RoundDto roundDto2 = new RoundDto();
        roundDto2.setId(2L);

        when(competitionService.getCompetitionById(competitionId)).thenReturn(Optional.of(competition));
        when(modelMapper.map(round1, RoundDto.class)).thenReturn(roundDto1);
        when(modelMapper.map(round2, RoundDto.class)).thenReturn(roundDto2);

        List<RoundDto> result = competitionController.getCompetitionRounds(competitionId);

        assertEquals(2, result.size());
        assertEquals(roundDto1.getId(), result.get(0).getId());
        assertEquals(roundDto2.getId(), result.get(1).getId());
    }

    @Test
    void testGetCompetitionRounds_CompetitionNotFound() {
        Long competitionId = 1L;

        when(competitionService.getCompetitionById(competitionId)).thenReturn(Optional.empty());

        assertThrows(CompetitionNotFoundException.class, () -> {
            competitionController.getCompetitionRounds(competitionId);
        });
    }
}
