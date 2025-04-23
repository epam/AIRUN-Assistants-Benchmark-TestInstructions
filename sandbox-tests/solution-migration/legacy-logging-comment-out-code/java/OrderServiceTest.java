package com.epam.aicode.java;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private OrderService orderService;
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();

        Logger rootLogger = (Logger) LoggerFactory.getLogger(OrderService.class);
        listAppender = new ListAppender<>();
        listAppender.start();

        rootLogger.addAppender(listAppender);
    }

    @Test
    void testProcessOrderNullOrderId() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn(null);

        orderService.processOrder(order);

        assertEquals(1, listAppender.list.size());
        assertEquals("Order ID is null or empty", listAppender.list.get(0).getMessage());
    }

    @Test
    void testProcessOrderEmptyOrderId() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn("");

        orderService.processOrder(order);

        assertEquals(1, listAppender.list.size());
        assertEquals("Order ID is null or empty", listAppender.list.get(0).getMessage());
    }

    @Test
    void testProcessOrderWithProducts() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn("123");

        Product product = mock(Product.class);
        when(product.getProductId()).thenReturn("456");
        when(product.getProductName()).thenReturn("TestProduct");

        when(order.getProducts()).thenReturn(Collections.singletonList(product));

        orderService.processOrder(order);

        assertEquals(3, listAppender.list.size());
        assertEquals("Processing order: 123", listAppender.list.get(0).getFormattedMessage());
        assertEquals("Processed product: 456", listAppender.list.get(1).getFormattedMessage());
        assertEquals("Order 123 processed successfully", listAppender.list.get(2).getFormattedMessage());
    }

    @Test
    void testProcessOrderExceptionHandling() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn("123");
        when(order.getProducts()).thenThrow(new RuntimeException("Test Exception"));

        orderService.processOrder(order);

        assertEquals(2, listAppender.list.size());

        assertEquals("Processing order: 123", listAppender.list.get(0).getFormattedMessage());
        assertEquals("Error processing order: 123", listAppender.list.get(1).getFormattedMessage());
        assertEquals("Test Exception", listAppender.list.get(1).getThrowableProxy().getMessage());
    }

    @Test
    void testProcessOrderMultipleProducts() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn("123");

        Product product1 = mock(Product.class);
        when(product1.getProductId()).thenReturn("101");
        when(product1.getProductName()).thenReturn("Product1");

        Product product2 = mock(Product.class);
        when(product2.getProductId()).thenReturn("102");
        when(product2.getProductName()).thenReturn("Product2");

        when(order.getProducts()).thenReturn(List.of(product1, product2));

        orderService.processOrder(order);

        assertEquals(4, listAppender.list.size());
        assertEquals("Processing order: 123", listAppender.list.get(0).getFormattedMessage());
        assertEquals("Processed product: 101", listAppender.list.get(1).getFormattedMessage());
        assertEquals("Processed product: 102", listAppender.list.get(2).getFormattedMessage());
        assertEquals("Order 123 processed successfully", listAppender.list.get(3).getFormattedMessage());
    }

    @Test
    void testProcessOrderWithOneNullProduct() {
        Order order = mock(Order.class);
        when(order.getOrderId()).thenReturn("123");

        Product product = mock(Product.class);
        when(product.getProductId()).thenReturn(null);
        when(product.getProductName()).thenReturn(null);

        when(order.getProducts()).thenReturn(Collections.singletonList(product));

        orderService.processOrder(order);

        assertEquals(3, listAppender.list.size());
        assertEquals("Processing order: 123", listAppender.list.get(0).getFormattedMessage());
        assertEquals("Processed product: null", listAppender.list.get(1).getFormattedMessage());
        assertEquals("Order 123 processed successfully", listAppender.list.get(2).getFormattedMessage());
    }
}