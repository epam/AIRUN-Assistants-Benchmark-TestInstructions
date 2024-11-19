package com.golf.app.service;

import com.golf.app.model.Marker;
import com.golf.app.repo.MarkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarkerServiceTest {

    private static final String TEST_MARKER_1 = "TestMarker1";
    private static final String TEST_MARKER_2 = "TestMarker2";
    private static final String TEST_MARKER = "TestMarker";

    private static final long MARKER_ID_1 = 1L;
    private static final long MARKER_ID_2 = 2L;

    @Mock
    private MarkerRepository markerRepository;

    @InjectMocks
    private MarkerService markerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllMarkers() {
        Marker marker1 = new Marker();
        marker1.setName(TEST_MARKER_1);
        marker1.setId(MARKER_ID_1);

        Marker marker2 = new Marker();
        marker2.setName(TEST_MARKER_2);
        marker2.setId(MARKER_ID_2);

        when(markerRepository.findAll()).thenReturn(Arrays.asList(marker1, marker2));

        Iterable<Marker> resultIterable = markerService.getAllMarkers();
        List<Marker> result = StreamSupport.stream(resultIterable.spliterator(), false)
            .collect(Collectors.toList());

        assertEquals(2, result.size());
        assertEquals(TEST_MARKER_1, result.get(0).getName());
        assertEquals(TEST_MARKER_2, result.get(1).getName());
    }

    @Test
    void getMarkerById() {
        Marker marker = new Marker();
        marker.setName(TEST_MARKER);
        marker.setId(MARKER_ID_1);

        when(markerRepository.findById(MARKER_ID_1)).thenReturn(Optional.of(marker));

        Optional<Marker> result = markerService.getMarkerById(MARKER_ID_1);

        assertTrue(result.isPresent());
        assertEquals(TEST_MARKER, result.get().getName());
    }

    @Test
    void saveMarker() {
        Marker marker = new Marker();
        marker.setName(TEST_MARKER);
        marker.setId(MARKER_ID_1);

        when(markerRepository.save(marker)).thenReturn(marker);

        Marker savedMarker = markerService.saveMarker(marker);

        assertEquals(TEST_MARKER, savedMarker.getName());
    }

    @Test
    void updateMarker_WhenMarkerExists_ShouldUpdateAndReturnMarker() {
        Long markerId = 1L;

        Marker existingMarker = new Marker();
        existingMarker.setId(markerId);
        existingMarker.setName("John");
        existingMarker.setSurname("Doe");

        Marker updatedMarkerDetails = new Marker();
        updatedMarkerDetails.setName("Jane");
        updatedMarkerDetails.setSurname("Smith");

        when(markerRepository.findById(markerId)).thenReturn(Optional.of(existingMarker));
        when(markerRepository.save(any(Marker.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Marker> result = markerService.updateMarker(markerId, updatedMarkerDetails);

        assertTrue(result.isPresent());
        Marker updatedMarker = result.get();
        assertEquals("Jane", updatedMarker.getName());
        assertEquals("Smith", updatedMarker.getSurname());
        assertEquals(markerId, updatedMarker.getId());

        verify(markerRepository).findById(markerId);
        verify(markerRepository).save(any(Marker.class));
    }

    @Test
    void updateMarker_WhenMarkerDoesNotExist_ShouldReturnEmptyOptional() {
        Long markerId = 1L;

        Marker updatedMarkerDetails = new Marker();
        updatedMarkerDetails.setName("Jane");
        updatedMarkerDetails.setSurname("Smith");

        when(markerRepository.findById(markerId)).thenReturn(Optional.empty());

        Optional<Marker> result = markerService.updateMarker(markerId, updatedMarkerDetails);

        assertTrue(result.isEmpty());

        verify(markerRepository).findById(markerId);
        verify(markerRepository, never()).save(any(Marker.class));
    }

    @Test
    void deleteMarker_WhenMarkerExists_ShouldReturnTrue() {
        Long markerId = 1L;

        Marker existingMarker = new Marker();
        existingMarker.setId(markerId);

        when(markerRepository.findById(markerId)).thenReturn(Optional.of(existingMarker));
        doNothing().when(markerRepository).deleteById(markerId);

        boolean result = markerService.deleteMarker(markerId);

        assertTrue(result);

        verify(markerRepository).findById(markerId);
        verify(markerRepository).deleteById(markerId);
    }

    @Test
    void deleteMarker_WhenMarkerDoesNotExist_ShouldReturnFalse() {
        Long markerId = 1L;

        when(markerRepository.findById(markerId)).thenReturn(Optional.empty());

        boolean result = markerService.deleteMarker(markerId);

        assertFalse(result);

        verify(markerRepository).findById(markerId);
        verify(markerRepository, never()).deleteById(anyLong());
    }
}
