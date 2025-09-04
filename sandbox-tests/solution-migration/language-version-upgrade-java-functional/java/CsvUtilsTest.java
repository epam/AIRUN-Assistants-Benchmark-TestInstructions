import com.epam.aicode.java.CsvUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvUtilsTest {

    private static final String DATA_PREFIX = "data";

    @TempDir
    Path tempDir;
    File directory;

    @BeforeEach
    void setUp() throws IOException {
        Files.createFile(tempDir.resolve("data_2023.csv"));
        Files.createFile(tempDir.resolve("data_2024.csv"));
        Files.createFile(tempDir.resolve("report_2023.csv"));
        Files.createFile(tempDir.resolve("info.txt"));
        Files.createFile(tempDir.resolve("data.xml"));
        Files.createFile(tempDir.resolve("other_file.csv"));
        directory = tempDir.toFile();
    }

    @Nested
    class ValidInputTests {
        @Test
        void shouldReturnMatchingCsvFilesWithPrefix() {
            List<String> result = CsvUtils.collectCsvFiles(DATA_PREFIX, directory);

            assertEquals(2, result.size());
            assertTrue(result.contains("data_2023.csv"));
            assertTrue(result.contains("data_2024.csv"));
        }

        @Test
        void shouldReturnAllCsvFilesWithEmptyPrefix() {
            List<String> result = CsvUtils.collectCsvFiles("", directory);

            assertEquals(4, result.size());
            assertTrue(result.contains("data_2023.csv"));
            assertTrue(result.contains("data_2024.csv"));
            assertTrue(result.contains("report_2023.csv"));
            assertTrue(result.contains("other_file.csv"));
        }

        @Test
        void shouldReturnSingleFileWithExactPrefix() {
            List<String> result = CsvUtils.collectCsvFiles("report_2023", directory);

            assertEquals(1, result.size());
            assertTrue(result.contains("report_2023.csv"));
        }

        @Test
        void shouldHandleSpecialCharactersInPrefix() throws IOException {
            Files.createFile(tempDir.resolve("test-file_123.csv"));
            Files.createFile(tempDir.resolve("test-file_456.csv"));

            List<String> result = CsvUtils.collectCsvFiles("test-file", directory);

            assertEquals(2, result.size());
            assertTrue(result.contains("test-file_123.csv"));
            assertTrue(result.contains("test-file_456.csv"));
        }
    }

    @Nested
    class EdgeCaseTests {
        @Test
        void shouldReturnEmptyListForNonExistentPrefix() {
            List<String> result = CsvUtils.collectCsvFiles("nonexistent", directory);

            assertTrue(result.isEmpty());
        }

        @Test
        void shouldReturnEmptyListForNonCsvMatches() {
            List<String> result = CsvUtils.collectCsvFiles("info", directory);

            assertTrue(result.isEmpty());
        }

        @Test
        void shouldBeCaseSensitive() throws IOException {
            Files.createFile(tempDir.resolve("Data_uppercase.csv"));

            List<String> result = CsvUtils.collectCsvFiles(DATA_PREFIX, directory);

            assertEquals(2, result.size());
            assertFalse(result.contains("Data_uppercase.csv"));
        }
    }

    @Nested
    class ErrorTests {
        @Test
        void shouldThrowNullPointerForNullDirectory() {
            assertThrows(NullPointerException.class, () ->
                CsvUtils.collectCsvFiles(DATA_PREFIX, null));
        }

        @Test
        void shouldThrowNullPointerForNonExistentDirectory() {
            File nonExistentDir = tempDir.resolve("nonexistent").toFile();

            assertThrows(NullPointerException.class, () ->
                CsvUtils.collectCsvFiles(DATA_PREFIX, nonExistentDir));
        }

        @Test
        void shouldThrowNullPointerForFileInsteadOfDirectory() {
            File file = tempDir.resolve("data_2023.csv").toFile();

            assertThrows(NullPointerException.class, () ->
                CsvUtils.collectCsvFiles(DATA_PREFIX, file));
        }
    }
}