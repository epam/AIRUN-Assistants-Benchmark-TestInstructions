import com.epam.aicode.java.Employee;
import com.epam.aicode.java.EmployeeDTO;
import com.epam.aicode.java.EmployeeMapperMapstruct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperMapstructTest {

    private static final Long ID = 123789L;
    private static final String NAME = "John Wickerman";
    private static final String EMAIL = "john.wickerman@mail.test";


    @Test
    public void testEmployeeToEmployeeDTO() {
        Employee employee = new Employee();
        employee.setId(ID);
        employee.setName(NAME);
        employee.setEmail(EMAIL);

        EmployeeDTO employeeDTO = EmployeeMapperMapstruct.INSTANCE.employeeToEmployeeDTO(employee);

        assertEquals(ID, employeeDTO.getId());
        assertEquals(NAME, employeeDTO.getName());
        assertEquals(EMAIL, employeeDTO.geteMail());
    }
}
