import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.epam.aicode.java.EcommerceSorting.priceSorting;

class EcommerceSortingTest {

    private static Map<String, BigDecimal> products;

    @BeforeEach
    void setUp() {
        products = new HashMap<>();
        products.put("Product A", new BigDecimal("19.99"));
        products.put("Product B", new BigDecimal("9.99"));
        products.put("Product C", new BigDecimal("14.99"));
        products.put("Product D", new BigDecimal("29.99"));
        products.put("Product E", new BigDecimal("24.99"));
    }

    @Test
    void testPriceSortingAscending() {
        Map<String, BigDecimal> sortedProducts = priceSorting(products, "ASC");

        BigDecimal previousPrice = BigDecimal.ZERO;
        for (BigDecimal price : sortedProducts.values()) {
            Assertions.assertTrue(price.compareTo(previousPrice) >= 0);
            previousPrice = price;
        }
    }

    @Test
    void testPriceSortingDescending() {
        Map<String, BigDecimal> sortedProducts = priceSorting(products, "DESC");

        BigDecimal previousPrice = new BigDecimal(Double.MAX_VALUE);
        for (BigDecimal price : sortedProducts.values()) {
            Assertions.assertTrue(price.compareTo(previousPrice) <= 0);
            previousPrice = price;
        }
    }
}