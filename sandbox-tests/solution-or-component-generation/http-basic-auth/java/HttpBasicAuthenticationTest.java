package com.epam.aicode.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Base64;
import org.junit.jupiter.api.Test;

class HttpBasicAuthenticationTest {

    private final HttpBasicAuthentication httpBasicAuthentication = new HttpBasicAuthentication();

    @Test
    public void testGetBasicAuthenticationHeader() {
        String baseAuthHeader = httpBasicAuthentication.createHttpBasicAuthenticationHeader(
            "username", "password");

        String[] splittedBaseAuthHeader = baseAuthHeader.split(" ");
        assertEquals(2, splittedBaseAuthHeader.length);
        assertEquals("Basic", splittedBaseAuthHeader[0]);
        assertEquals("username:password", new String(Base64.getDecoder().decode(splittedBaseAuthHeader[1])));
    }
}