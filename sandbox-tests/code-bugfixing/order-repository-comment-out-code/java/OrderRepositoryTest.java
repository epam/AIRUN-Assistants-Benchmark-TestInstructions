package com.aicode.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();

        Order order1 = new Order();
        order1.setStatus("COMPLETED");
        order1.setCustomerId(1L);
        order1.setTotalCost(150.00);
        order1.setOrderDate(LocalDateTime.now().minusDays(2));

        Order order2 = new Order();
        order2.setStatus("PENDING");
        order2.setCustomerId(2L);
        order2.setTotalCost(300.00);
        order2.setOrderDate(LocalDateTime.now().minusDays(10));

        Order order3 = new Order();
        order3.setStatus("DELIVERED");
        order3.setCustomerId(1L);
        order3.setTotalCost(200.00);
        order3.setOrderDate(LocalDateTime.now().minusDays(20));

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
    }

    @Test
    void testFindOrdersByExactTotalCostRangeAndDateRange() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Order> resultPage = orderRepository.findOrdersByStatusAndCustomerAndCostRangeAndDateRange(
            null, null, 150.00, 150.00, LocalDateTime.now().minusDays(5),
            LocalDateTime.now().plusDays(1), pageable
        );

        List<Order> orders = resultPage.getContent();

        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getTotalCost()).isEqualTo(150.00);
    }

    @Test
    void testFindOrdersByStatusOnly() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Order> resultPage = orderRepository.findOrdersByStatusAndCustomerAndCostRangeAndDateRange(
            "PENDING", null, null, null, null, null, pageable
        );

        List<Order> orders = resultPage.getContent();

        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getStatus()).isEqualTo("PENDING");
    }

    @Test
    void testFindOrdersByCustomerAndStatus() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Order> resultPage = orderRepository.findOrdersByStatusAndCustomerAndCostRangeAndDateRange(
            "COMPLETED", 1L, null, null, null, null, pageable
        );

        List<Order> orders = resultPage.getContent();

        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getCustomerId()).isEqualTo(1L);
    }

    @Test
    void testFindOrdersWithNoFilters() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Order> resultPage = orderRepository.findOrdersByStatusAndCustomerAndCostRangeAndDateRange(
            null, null, null, null, null, null, pageable
        );

        List<Order> orders = resultPage.getContent();

        assertThat(orders).hasSize(3);
    }
}
