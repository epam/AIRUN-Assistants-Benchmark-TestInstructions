package com.epam.aicode.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class FileTypeRegistryTest {

    private final FileTypeRegistry fileTypeRegistry = new FileTypeRegistry();

    @Test
    public void testTop10FileExtensionTypesWithDot() {
        String[] fileExtensionTypes = fileTypeRegistry.top10FileExtensionTypesWithDot;

        assertNotNull(fileExtensionTypes);
        assertEquals(fileExtensionTypes.length, 10);
        assertEquals(new HashSet<>(Arrays.asList(fileExtensionTypes)).size(), 10);
        assertTrue(Arrays.stream(fileExtensionTypes).allMatch(f -> f.startsWith(".")));
    }
}