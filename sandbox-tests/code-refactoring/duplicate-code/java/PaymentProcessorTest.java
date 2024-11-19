import com.epam.aicode.java.Payment;
import com.epam.aicode.java.PaymentProcessor;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentProcessorTest {

    private static final String ACTIVE = "active";
    private static final String CREDIT = "credit";
    private static final String HDFC = "HDFC";
    private static final String ICICI = "ICICI";
    private static final String ONLINE = "online";
    private static final String OFFLINE = "offline";

    private final PaymentProcessor paymentProcessor = new PaymentProcessor();

    @Test
    public void testProcessPaymentOnline() {
        Payment payment = paymentProcessor.processPayment(true);

        assertEquals(ONLINE, payment.getPaymentMode());
        assertEquals(ICICI, payment.getPaymentBank());
        assertEquals(CREDIT, payment.getPaymentType());
        assertEquals(ACTIVE, payment.getPaymentStatus());
        assertNotNull(payment.getPaymentDate());
    }

    @Test
    public void testProcessPaymentOffline() {
        Payment payment = paymentProcessor.processPayment(false);

        assertEquals(OFFLINE, payment.getPaymentMode());
        assertEquals(HDFC, payment.getPaymentBank());
        assertEquals(CREDIT, payment.getPaymentType());
        assertEquals(ACTIVE, payment.getPaymentStatus());
        assertNotNull(payment.getPaymentDate());
    }

    @Test
    public void testProcessPaymentContainDuplicateCode() throws IOException {
        JavaClass javaClass = getPaymentProcessorClass();
        String methodSourceCode = javaClass.getMethods().get(0).getSourceCode();

        Map<String, Integer> sourceCodeMap = new HashMap<>();
        Scanner scanner = new Scanner(methodSourceCode);
        scanner.useDelimiter(";\\s*");

        while (scanner.hasNext()) {
            String code = scanner.next();
            if (code.equals("payment.setPaymentDate(LocalDate.now())") ||
                code.equals("payment.setPaymentStatus(ACTIVE)") ||
                code.equals("payment.setPaymentType(CREDIT)")) {
                sourceCodeMap.put(code, sourceCodeMap.getOrDefault(code, 0) + 1);
            }
        }

        assertFalse(sourceCodeMap.getOrDefault("payment.setPaymentDate(LocalDate.now())", 0) > 1);
        assertFalse(sourceCodeMap.getOrDefault("payment.setPaymentStatus(ACTIVE)", 0) > 1);
        assertFalse(sourceCodeMap.getOrDefault("payment.setPaymentType(CREDIT)", 0) > 1);
    }

    private JavaClass getPaymentProcessorClass() throws IOException {
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        JavaSource javaSource = javaProjectBuilder.
            addSource(new File("src/main/java/com/epam/aicode/java/PaymentProcessor.java"));
        return javaSource.getClasses().get(0);
    }
}
