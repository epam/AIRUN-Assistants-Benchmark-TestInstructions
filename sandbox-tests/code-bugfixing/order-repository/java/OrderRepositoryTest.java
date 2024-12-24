package com.aicode.java;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    private LocalDateTime fixedNow;

    @BeforeEach
    public void setUp() {
        fixedNow = LocalDateTime.now().withSecond(0).withNano(0);
        orderRepository.saveAll(setupOrders());
    }

    @Test
    public void shouldReturnOrdersWithMultipleFilters() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Order> ordersPage = orderRepository.findOrders(
            "SHIPPED", 101L, 400.0, 600.0, null, null, pageable
        );

        assertThat(ordersPage.getTotalElements()).isEqualTo(1);
        assertThat(ordersPage.getContent().get(0).getCustomerId()).isEqualTo(101L);
    }

    @Test
    public void shouldReturnOrdersWithinBoundaryDates() {
        Pageable pageable = PageRequest.of(0, 10);
        LocalDateTime startDate = fixedNow.minusDays(5);
        LocalDateTime endDate = fixedNow;

        Page<Order> ordersPage = orderRepository.findOrders(
            null, null, null, null, startDate, endDate, pageable
        );

        assertThat(ordersPage.getTotalElements()).isEqualTo(4);
    }

    @Test
    public void shouldReturnOrdersForExactMinMaxTotalCost() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Order> ordersPage1 = orderRepository.findOrders(
            null, null, 200.0, 200.0, null, null, pageable
        );
        assertThat(ordersPage1.getTotalElements()).isEqualTo(1);
        assertThat(ordersPage1.getContent().get(0).getTotalCost()).isEqualTo(200.0);

        Page<Order> ordersPage2 = orderRepository.findOrders(
            null, null, 800.0, 800.0, null, null, pageable
        );
        assertThat(ordersPage2.getTotalElements()).isEqualTo(1);
        assertThat(ordersPage2.getContent().get(0).getTotalCost()).isEqualTo(800.0);
    }

    @Test
    public void shouldReturnOrdersWithNullValuesInEntityFields() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Order> ordersPage = orderRepository.findOrders(
            null, 102L, null, null, null, null, pageable
        );

        assertThat(ordersPage.getTotalElements()).isEqualTo(1);
        assertThat(ordersPage.getContent().get(0).getStatus()).isNull();
    }

    private List<Order> setupOrders() {
        return List.of(
            createOrder(100L, fixedNow.minusDays(1), "NEW", 200.0),
            createOrder(101L, fixedNow.minusDays(2), "SHIPPED", 500.0),
            createOrder(102L, fixedNow, null, 50.0),
            createOrder(103L, fixedNow.minusDays(5), "CANCELLED", 800.0)
        );
    }

    private Order createOrder(Long customerId, LocalDateTime orderDate, String status, Double totalCost) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(orderDate);
        order.setStatus(status);
        order.setTotalCost(totalCost);
        return order;
    }
}
