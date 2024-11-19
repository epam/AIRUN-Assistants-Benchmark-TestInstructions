package com.golf.app.utils;

import com.golf.app.model.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreUtilsTest {

    private ScoreUtils scoreUtils;

    @Test
    public void testSetStableford() {
        Score score = new Score();

        scoreUtils.setStableford(score, 1);
        assertEquals(1, score.getStableford());

        scoreUtils.setStableford(score, 0);
        assertEquals(2, score.getStableford());

        scoreUtils.setStableford(score, -1);
        assertEquals(3, score.getStableford());

        scoreUtils.setStableford(score, -2);
        assertEquals(4, score.getStableford());

        scoreUtils.setStableford(score, -3);
        assertEquals(5, score.getStableford());

        scoreUtils.setStableford(score, 2);
        assertEquals(0, score.getStableford());
    }
}
