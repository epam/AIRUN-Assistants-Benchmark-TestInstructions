import com.epam.aicode.java.Discount;
import com.epam.aicode.java.DiscountAction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DiscountActionTest {

    private static final String CHILD = "CHILD";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String SENIOR = "SENIOR";
    private static final String STUDENT = "STUDENT";

    private final DiscountAction discountAction = new DiscountAction();

    @Test
    public void testCalculateDiscountStudent() {
        Discount discount = discountAction.calculateDiscount(100, STUDENT, false);

        assertEquals(10, discount.getRate());
        assertEquals(STUDENT, discount.getUserType());
        assertFalse(discount.isHoliday());
    }

    @Test
    public void testCalculateDiscountSenior() {
        Discount discount = discountAction.calculateDiscount(100, SENIOR, false);

        assertEquals(15, discount.getRate());
        assertEquals(SENIOR, discount.getUserType());
        assertFalse(discount.isHoliday());
    }

    @Test
    public void testCalculateDiscountEmployee() {
        Discount discount = discountAction.calculateDiscount(100, EMPLOYEE, false);

        assertEquals(20, discount.getRate());
        assertEquals(EMPLOYEE, discount.getUserType());
        assertFalse(discount.isHoliday());
    }

    @Test
    public void testCalculateDiscountNoDiscount() {
        Discount discount = discountAction.calculateDiscount(100, CHILD, false);

        assertEquals(0, discount.getRate());
        assertEquals(CHILD, discount.getUserType());
        assertFalse(discount.isHoliday());
    }
}
