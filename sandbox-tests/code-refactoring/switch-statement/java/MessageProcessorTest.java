import com.epam.aicode.java.Message;
import com.epam.aicode.java.MessageException;
import com.epam.aicode.java.MessageProcessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageProcessorTest {

    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Test
    public void testHandleMessageError100() {
        Message message = new Message();
        message.setErrorCode("100");
        try {
            messageProcessor.handleMessageError(message);
        } catch (MessageException e) {
            assertEquals("Exception with code 100 occurred while processing the message", e.getMessage());
        }
    }

    @Test
    public void testHandleMessageError200() {
        Message message = new Message();
        message.setErrorCode("200");
        try {
            messageProcessor.handleMessageError(message);
        } catch (MessageException e) {
            assertEquals("Exception with code 200 occurred while processing the message", e.getMessage());
        }
    }

    @Test
    public void testHandleMessageError300() {
        Message message = new Message();
        message.setErrorCode("300");
        try {
            messageProcessor.handleMessageError(message);
        } catch (MessageException e) {
            assertEquals("Exception with code 300 occurred while processing the message", e.getMessage());
        }
    }

    @Test
    public void testHandleMessageErrorHasSwitchStatement() throws IOException {
        try (BufferedReader br = new BufferedReader(
            new FileReader("src/main/java/com/epam/aicode/java/MessageProcessor.java"))) {
            String line;
            boolean isSwitchStatementFound = false;
            while ((line = br.readLine()) != null) {
                if (line.contains("switch")) {
                    isSwitchStatementFound = true;
                    break;
                }
            }
            assertTrue(isSwitchStatementFound,  "The switch statement was not found in the file");
        }
    }
}
