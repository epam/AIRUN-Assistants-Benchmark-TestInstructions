package com.aicode.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProcessorTest {

    @Test
    void testCalculateMostPopularProductWithRecentOrders() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, -10);
        Date tenDaysAgo = calendar.getTime();

        Product productA = new Product("A001", "ProductA", 10, 100.0);
        Product productB = new Product("B001", "ProductB", 20, 150.0);
        Product productC = new Product("C001", "ProductC", 15, 200.0);

        Order order1 = new Order("O001", "C001", tenDaysAgo, Arrays.asList(productA, productB));
        Order order2 = new Order("O002", "C002", currentDate, Arrays.asList(productB, productC));

        List<Order> orders = Arrays.asList(order1, order2);

        OrderProcessor orderProcessor = new OrderProcessor();
        String mostPopularProduct = orderProcessor.calculateMostPopularProduct(orders);

        assertEquals("ProductB", mostPopularProduct);
    }

    @Test
    void testCalculateMostPopularProductNoRecentOrders() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -40); // 40 days ago
        Date fortyDaysAgo = calendar.getTime();

        Product productA = new Product("A001", "ProductA", 10, 100.0);

        Order oldOrder = new Order("O001", "C001", fortyDaysAgo, Arrays.asList(productA));

        List<Order> orders = Arrays.asList(oldOrder);

        OrderProcessor orderProcessor = new OrderProcessor();
        String mostPopularProduct = orderProcessor.calculateMostPopularProduct(orders);

        assertEquals("No Products", mostPopularProduct);
    }

    @Test
    void testCalculateMostPopularProductEmptyOrderList() {
        List<Order> orders = Arrays.asList();

        OrderProcessor orderProcessor = new OrderProcessor();
        String mostPopularProduct = orderProcessor.calculateMostPopularProduct(orders);

        assertEquals("No Products", mostPopularProduct);
    }

    @Test
    void testCalculateMostPopularProductWithTieInQuantities() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -15);
        Date fifteenDaysAgo = calendar.getTime();

        Product productA = new Product("A001", "ProductA", 10, 100.0);
        Product productB = new Product("B001", "ProductB", 10, 150.0);

        Order order1 = new Order("O001", "C001", fifteenDaysAgo, Arrays.asList(productA));
        Order order2 = new Order("O002", "C002", fifteenDaysAgo, Arrays.asList(productB));

        List<Order> orders = Arrays.asList(order1, order2);

        OrderProcessor orderProcessor = new OrderProcessor();
        String mostPopularProduct = orderProcessor.calculateMostPopularProduct(orders);

        assertEquals("ProductA", mostPopularProduct);
    }
}