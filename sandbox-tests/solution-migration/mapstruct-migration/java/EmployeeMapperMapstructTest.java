import com.epam.aicode.java.Employee;
import com.epam.aicode.java.EmployeeDTO;
import com.epam.aicode.java.EmployeeMapperMapstruct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperMapstructTest {

    private static final String NAME = "name";
    private static final String EMAIL = "email";


    @Test
    public void testEmployeeToEmployeeDTO() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName(NAME);
        employee.setEmail(EMAIL);

        EmployeeDTO employeeDTO = EmployeeMapperMapstruct.INSTANCE.employeeToEmployeeDTO(employee);

        assertEquals(1L, employeeDTO.getId().longValue());
        assertEquals(NAME, employeeDTO.getName());
        assertEquals(EMAIL, employeeDTO.getEmail());
    }
}
