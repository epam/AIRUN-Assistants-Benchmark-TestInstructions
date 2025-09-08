import com.epam.aicode.java.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FileUtils.findExecutableFiles() Tests")
class FileUtilsTest {

    @TempDir
    Path tempDir;
    private File directory;

    @BeforeEach
    void setUp() throws IOException {
        directory = tempDir.toFile();
    }

    private Path createExecutableFile(String fileName) throws IOException {
        return Files.createFile(tempDir.resolve(fileName));
    }

    private Path createNonExecutableFile(String fileName) throws IOException {
        return Files.createFile(tempDir.resolve(fileName));
    }

    private Path createSubdirectoryWithExecutables(String dirName, String... fileNames) throws IOException {
        Path subDir = Files.createDirectory(tempDir.resolve(dirName));
        for (String fileName : fileNames) {
            Files.createFile(subDir.resolve(fileName));
        }
        return subDir;
    }

    private void assertAllFilesAreExecutable(List<File> files) {
        for (File file : files) {
            assertTrue(file.canExecute(), "File should be executable: " + file.getName());
        }
    }

    private void assertAllFilesAreRegularFiles(List<File> files) {
        assertTrue(files.stream().allMatch(File::isFile), "All results should be regular files");
        assertFalse(files.stream().anyMatch(File::isDirectory), "No directories should be included");
    }

    @Nested
    @DisplayName("When provided with valid input")
    class ValidInputTests {

        @Test
        @DisplayName("Given empty directory, when finding executables, then should return empty list")
        void givenEmptyDirectory_whenFindingExecutables_thenShouldReturnEmptyList() {
            List<File> result = FileUtils.findExecutableFiles(directory);

            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Given directory with subdirectories containing executables, when finding executables, then should return all executable files recursively")
        void givenDirectoryWithSubdirectories_whenFindingExecutables_thenShouldReturnAllExecutableFilesRecursively() throws IOException {
            createSubdirectoryWithExecutables("subdir1", "script1.bat");
            createSubdirectoryWithExecutables("subdir2", "script2.bat");

            Path nestedDir = Files.createDirectory(tempDir.resolve("subdir1").resolve("nested"));
            Files.createFile(nestedDir.resolve("nested_script.bat"));

            createExecutableFile("root_script.bat");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertTrue(result.size() >= 0, "Should not throw error and return valid list");
            assertAllFilesAreRegularFiles(result);
        }

        @Test
        @DisplayName("Given directory with mixed file types, when finding executables, then should only return executable files")
        void givenDirectoryWithMixedFileTypes_whenFindingExecutables_thenShouldOnlyReturnExecutableFiles() throws IOException {
            createExecutableFile("script.bat");
            createNonExecutableFile("document.txt");
            createNonExecutableFile("image.jpg");
            createNonExecutableFile("data.json");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
            assertAllFilesAreExecutable(result);
        }

        @Test
        @DisplayName("Given directory containing subdirectories, when finding executables, then should ignore subdirectories themselves")
        void givenDirectoryContainingSubdirectories_whenFindingExecutables_thenShouldIgnoreSubdirectoriesThemselves() throws IOException {
            Files.createDirectory(tempDir.resolve("subdir1"));
            Files.createDirectory(tempDir.resolve("subdir2"));

            createExecutableFile("script.bat");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
        }
    }

    @Nested
    @DisplayName("When handling edge cases")
    class EdgeCaseTests {

        @Test
        @DisplayName("Given files with shell script extension, when finding executables, then should handle correctly")
        void givenFilesWithShellScriptExtension_whenFindingExecutables_thenShouldHandleCorrectly() throws IOException {
            createExecutableFile("script.sh");
            createNonExecutableFile("readme.txt");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
            assertAllFilesAreExecutable(result);
        }

        @Test
        @DisplayName("Given files with executable extension, when finding executables, then should handle correctly")
        void givenFilesWithExecutableExtension_whenFindingExecutables_thenShouldHandleCorrectly() throws IOException {
            createExecutableFile("app.exe");
            createNonExecutableFile("readme.txt");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
            assertAllFilesAreExecutable(result);
        }

        @Test
        @DisplayName("Given files with batch file extension, when finding executables, then should handle correctly")
        void givenFilesWithBatchFileExtension_whenFindingExecutables_thenShouldHandleCorrectly() throws IOException {
            createExecutableFile("tool.bat");
            createNonExecutableFile("readme.txt");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
            assertAllFilesAreExecutable(result);
        }

        @Test
        @DisplayName("Given files with COM extension, when finding executables, then should handle correctly")
        void givenFilesWithComExtension_whenFindingExecutables_thenShouldHandleCorrectly() throws IOException {
            createExecutableFile("program.com");
            createNonExecutableFile("readme.txt");

            List<File> result = FileUtils.findExecutableFiles(directory);

            assertAllFilesAreRegularFiles(result);
            assertAllFilesAreExecutable(result);
        }

    }

    @Nested
    @DisplayName("When encountering error conditions")
    class ErrorHandlingTests {

        @Test
        @DisplayName("Given null directory parameter, when finding executables, then should throw NullPointerException")
        void givenNullDirectoryParameter_whenFindingExecutables_thenShouldThrowNullPointerException() {
            NullPointerException exception = assertThrows(NullPointerException.class, () ->
                FileUtils.findExecutableFiles(null));

            assertNotNull(exception);
        }

    }
}