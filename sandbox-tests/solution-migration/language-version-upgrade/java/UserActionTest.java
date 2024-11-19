import com.epam.aicode.java.UserAction;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActionTest {

    private final UserAction userAction = new UserAction();
    private final List<String> names = Arrays.asList("John", "  ", "MariA", "AnDrEw", "", "kaTRIN", "david", null, "ROBERT");

    @Test
    public void testGetNormalizedNames() {
        String result = userAction.getNormalizedNames(names);

        assertEquals("Andrew-David-John-Katrin-Maria-Robert", result);
    }
}
