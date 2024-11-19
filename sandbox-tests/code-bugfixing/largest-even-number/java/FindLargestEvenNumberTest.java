package com.epam.poc.aicode.java;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindLargestEvenNumberTest {

    private static List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 3, 5, 7, 9);
    }

    @Test
    void testFindLargestEvenNumberFixedPass() {
        numbers = Arrays.asList(1, 3, 10, 5, 7, 9, 8);
        var largestEvenNumber = FindLargestEvenNumber.findLargestEvenNumber(numbers);
        assertEquals(10, largestEvenNumber);
    }

    @Test
    void testFindLargestEvenNumberMaxExpected() {
        assertDoesNotThrow(() ->
            FindLargestEvenNumber.findLargestEvenNumber(numbers)
        );
    }
}