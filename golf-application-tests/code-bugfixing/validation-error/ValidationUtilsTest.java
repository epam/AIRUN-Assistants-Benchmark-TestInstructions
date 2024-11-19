package com.golf.app.utils;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidationUtilsTest {

    private static final String FIELD_1 = "field1";
    private static final String OBJECT_NAME = "objectName";
    private static final String ERROR_MESSAGE_1 = "Error message 1";
    private static final String ERROR_MESSAGE_2 = "Error message 2";

    @Test
    public void testGetFieldErrors() {
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError1 = new FieldError(OBJECT_NAME, FIELD_1, ERROR_MESSAGE_1);
        FieldError fieldError2 = new FieldError(OBJECT_NAME, FIELD_1, ERROR_MESSAGE_2);
        when(bindingResult.getFieldErrors()).thenReturn(List.of(new FieldError[]{fieldError1, fieldError2}));

        Map<String, String> fieldErrors = ValidationUtils.getFieldErrors(bindingResult);

        String expectedPattern = ERROR_MESSAGE_1 + "[,;]\\s?" + ERROR_MESSAGE_2;

        assertTrue(fieldErrors.containsKey(FIELD_1));
        assertTrue(fieldErrors.get(FIELD_1).matches(expectedPattern));
    }
}
