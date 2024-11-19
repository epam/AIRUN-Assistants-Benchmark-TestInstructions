import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.aicode.java.KeyStoreCase;
import java.io.File;
import java.security.KeyStore;
import org.junit.jupiter.api.Test;

public class KeyStoreCaseTest {

    private final static String KEYSTORE_FILE_NAME = "keystore.jks";
    private final KeyStoreCase keyStoreCase = new KeyStoreCase();

    @Test
    public void testCreateKeystoreAndSaveToFile() throws Exception {
        KeyStore keyStore = keyStoreCase.createKeystoreAndSaveToFile(KEYSTORE_FILE_NAME, "password");

        assertNotNull(keyStore);
        assertEquals("JKS", keyStore.getType());
        assertEquals(0, keyStore.size());
        assertTrue(new File(KEYSTORE_FILE_NAME).exists());
    }
}
