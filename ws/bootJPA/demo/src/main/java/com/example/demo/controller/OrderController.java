package com.example.demo.controller;


import com.example.demo.domain.OrderDTO;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;
/*
    @GetMapping ("/orders")
    public ResponseEntity<Order> createOrder(@RequestParam( name="customerId") Long customerId, @RequestParam String productName) {
        Order order = orderService.createOrder(customerId, productName);
        return ResponseEntity.ok(order);
    }
*/

    @GetMapping("/orders/by-grade")
    public List<OrderDTO> getOrdersByGrade(@RequestParam (name="grade")String grade) {
        return orderService.getOrdersByCustomerGrade(grade);
    }
}

