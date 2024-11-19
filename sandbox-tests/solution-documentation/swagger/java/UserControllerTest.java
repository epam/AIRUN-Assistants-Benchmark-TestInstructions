import com.epam.aicode.java.User;
import com.epam.aicode.java.UserController;
import io.swagger.annotations.ApiOperation;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserControllerTest {

    @Test
    public void createUserHasApiOperationAnnotation() throws NoSuchMethodException {
        Method method = UserController.class.getMethod("createUser", User.class);

        assertTrue(method.isAnnotationPresent(ApiOperation.class));
        assertEquals(User.class, method.getAnnotation(ApiOperation.class).response());
    }

    @Test
    public void getUserHasApiOperationAnnotation() throws NoSuchMethodException {
        Method method = UserController.class.getMethod("getUser", Long.class);

        assertTrue(method.isAnnotationPresent(ApiOperation.class));
        assertEquals(User.class, method.getAnnotation(ApiOperation.class).response());
    }

    @Test
    public void getAllUsersHasApiOperationAnnotation() throws NoSuchMethodException {
        Method method = UserController.class.getMethod("getAllUsers");

        assertTrue(method.isAnnotationPresent(ApiOperation.class));
        assertEquals(List.class, method.getAnnotation(ApiOperation.class).response());
    }

    @Test
    public void updateUserHasApiOperationAnnotation() throws NoSuchMethodException {
        Method method = UserController.class.getMethod("updateUser", Long.class, User.class);

        assertTrue(method.isAnnotationPresent(ApiOperation.class));
        assertEquals(User.class, method.getAnnotation(ApiOperation.class).response());
    }

    @Test
    public void deleteUserHasApiOperationAnnotation() throws NoSuchMethodException {
        Method method = UserController.class.getMethod("deleteUser", Long.class);

        assertTrue(method.isAnnotationPresent(ApiOperation.class));
    }
}
