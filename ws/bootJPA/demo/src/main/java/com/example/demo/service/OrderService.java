package com.example.demo.service;


import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.domain.OrderDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // 주문 생성
    public Order createOrder(Long customerId, String productName) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isEmpty()) {
            throw new IllegalArgumentException("해당 고객 ID가 존재하지 않습니다: " + customerId);
        }

        Customer customer = customerOpt.get();
        Order order = new Order(productName, LocalDateTime.now(), customer);
        return orderRepository.save(order);
    }

    // 모든 주문 조회
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 고객 ID로 주문 조회
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
/*
    // 고객 등급으로 주문 조회
    public List<Order> getOrdersByCustomerGrade(String grade) {
        return orderRepository.findOrdersByCustomerGrade(grade);
    }
*/
public List<OrderDTO> getOrdersByCustomerGrade(String grade) {
    List<Order> orders = orderRepository.findOrdersByCustomerGrade(grade);

    // 엔티티 리스트를 DTO 리스트로 변환
    return orders.stream()
            .map(o -> new OrderDTO(
                    o.getId(),
                    o.getProductName(),
                    o.getOrderDate(),
                    o.getCustomer().getName()
            ))
            .toList();
}

    // 특정 상품명으로 주문 조회
    public List<Order> getOrdersByProductName(String productName) {
        return orderRepository.findByProductName(productName);
    }
}
