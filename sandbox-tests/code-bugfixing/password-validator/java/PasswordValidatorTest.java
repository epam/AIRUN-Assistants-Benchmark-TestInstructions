package com.aicode.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    @Test
    public void testValidPasswords() {
        assertTrue(PasswordValidator.isValidPassword("Password1!"));
        assertTrue(PasswordValidator.isValidPassword("StrongPass123$"));
        assertTrue(PasswordValidator.isValidPassword("Good#Pass1"));
        assertTrue(PasswordValidator.isValidPassword("Valid1@Pass"));
    }

    @Test
    public void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValidPassword("Pass1!"));
        assertFalse(PasswordValidator.isValidPassword("password1!"));
        assertFalse(PasswordValidator.isValidPassword("PASSWORD1!"));
        assertFalse(PasswordValidator.isValidPassword("Password!"));
        assertFalse(PasswordValidator.isValidPassword("Password1"));
        assertFalse(PasswordValidator.isValidPassword("Password 1!"));
        assertFalse(PasswordValidator.isValidPassword(null));
    }
}