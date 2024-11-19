import com.epam.aicode.java.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DBUtilsTest {

    private static final String PASSWORD = "123";
    private static final String SELECT_NAME_FROM_USER_SQL = "SELECT * FROM user WHERE name = 'Name2'";
    private static final String USER = "sa";
    private static final String URL_SOURCE_DB = "jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1";
    private static final String URL_DESTINATION_DB = "jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1";

    @Test
    public void testMigrateUsersToAnotherDatabase() throws SQLException {
        createUserTableWithDataInSourceDB();

        try (Connection sourceConnection = DBUtils.createDBConnection(URL_SOURCE_DB, USER, PASSWORD);
             Connection targetConnection = DBUtils.createDBConnection(URL_DESTINATION_DB, USER, PASSWORD);
             Statement targetStatement = targetConnection.createStatement()) {
            DBUtils.createUserTable(targetStatement);

            try (ResultSet resultSetTarget = targetStatement.executeQuery(SELECT_NAME_FROM_USER_SQL)) {
                assertFalse(resultSetTarget.next());
            }




            try (ResultSet resultSetTarget = targetStatement.executeQuery(SELECT_NAME_FROM_USER_SQL)) {
                assertTrue(resultSetTarget.next());
                assertEquals("Name2", resultSetTarget.getString("name"));

            }
        }
    }

    private void createUserTableWithDataInSourceDB() throws SQLException {
        try (Connection connection = DBUtils.createDBConnection(URL_SOURCE_DB, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            DBUtils.createUserTable(statement);
            DBUtils.insertUsersIntoUserTable(connection);
        }
    }
}
