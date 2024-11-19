package com.golf.app.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppConstantTest {

    @Test
    public void testConstantOrder() {
        String[] actualConstantsOrder = getConstantNames(AppConstant.class);

        String[] expectedConstantsOrder = {
            "COMPETITION_ATTRIBUTE",
            "COMPETITION_ROUNDS_MAP_ATTRIBUTE",
            "COMPETITIONS_ATTRIBUTE",
            "ERRORS_ATTRIBUTE",
            "PLAYER_ADD_PAGE",
            "PLAYER_ATTRIBUTE",
            "PLAYER_DETAILS_PAGE",
            "PLAYER_EDIT_PAGE",
            "PLAYER_MAIN_PAGE",
            "PLAYER_PHOTO_DTO_ATTRIBUTE",
            "PLAYER_SURNAME_NAME_ATTRIBUTE",
            "PLAYERS_ATTRIBUTE",
            "PLAYERS_SURNAME_NAME_LIST_ATTRIBUTE",
            "REDIRECT_COMPETITION_DETAILS_PAGE",
            "REDIRECT_ROUND",
            "REDIRECT_ROUND_EDIT_PAGE",
            "REDIRECT_TO_PLAYER",
            "ROUND_ADD_CHOOSE_COMPETITION_PAGE",
            "ROUND_ADD_PAGE",
            "ROUND_ATTRIBUTE",
            "ROUND_DETAILS_PAGE",
            "ROUND_EDIT_PAGE",
            "ROUND_MAIN_PAGE",
            "ROUND_PLAYERS_ATTRIBUTE",
            "ROUND_SCORE_ATTRIBUTE",
            "ROUND_SCORE_DTO_ATTRIBUTE",
            "ROUND_SCORE_INPUT_PAGE",
            "ROUND_SCORE_MAIN",
            "ROUND_SCORE_PAGE",
            "ROUNDS_ATTRIBUTE"
        };

        assertArrayEquals(expectedConstantsOrder, actualConstantsOrder);
    }

    private String[] getConstantNames(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
            .filter(field -> Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
            .map(Field::getName)
            .toArray(String[]::new);
    }
}