package com.epam.aicode.java;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateHandlerTest {

    private final DateHandler dateHandler = new DateHandler();

    @Test
    public void testGetCurrentDate() {
        LocalDate currentDate = dateHandler.getCurrentDate();
        LocalDate expectedDate = LocalDate.now();

        assertEquals(expectedDate.getDayOfMonth(), currentDate.getDayOfMonth());
        assertEquals(expectedDate.getMonth(), currentDate.getMonth());
        assertEquals(expectedDate.getYear(), currentDate.getYear());
    }

    @Test
    public void testFormatDate() {
        LocalDate dateToFormat = LocalDate.of(2023, 10, 1);
        String formattedDate = dateHandler.formatDate(dateToFormat);

        assertEquals("2023-10-01", formattedDate);
    }

    @Test
    public void testAddDaysToCurrentDate() {
        LocalDate currentDate = dateHandler.getCurrentDate();
        LocalDate newDate = dateHandler.addDaysToCurrentDate(5);

        assertEquals(currentDate.plusDays(5), newDate);
    }

    @Test
    public void testGetDayOfWeek() {
        LocalDate date = LocalDate.of(2023, 10, 1);
        String dayOfWeek = dateHandler.getDayOfWeek(date);

        assertTrue(dayOfWeek.equals("Sunday") || dayOfWeek.equals("SUNDAY"), dayOfWeek);
    }
}