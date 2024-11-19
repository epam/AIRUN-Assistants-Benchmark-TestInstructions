package com.epam.poc.aicode.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfEvenNumbersTest {

    @Test
    void testSumOfEvenNumbers() {
        int sum = SumOfEvenNumbers.sumOfEvenNumbers(1, 4);
        assertEquals(6, sum);
    }
}