import com.epam.aicode.java.DBUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DBUtilsTest {

    private static final String SELECT_NAME_FROM_EMPLOYEE_SQL = "SELECT * FROM user WHERE name = 'Name1'";

    @Test
    public void testInsertUsersIntoUserTable() throws SQLException {
        Connection connection = DBUtils.createDBConnection();
        Statement statement = connection.createStatement();
        DBUtils.createUserTable(statement);

        DBUtils.insertUsersIntoUserTable(connection);

        ResultSet resultSet = statement.executeQuery(SELECT_NAME_FROM_EMPLOYEE_SQL);
        assertTrue(resultSet.next());
        assertEquals("Name1", resultSet.getString("name"));
    }

    @Test
    public void testInsertUsersIntoUserTableHasPreparedStatement() throws IOException {
        String preparedStatement = "PreparedStatement";
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/epam/aicode/java/DBUtils.java"))) {
            String line;
            boolean isPreparedStatementFound = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(preparedStatement)) {
                    isPreparedStatementFound = true;
                    break;
                }
            }
            assertTrue(isPreparedStatementFound, "The PreparedStatement was not found in the file");
        }
    }
}
