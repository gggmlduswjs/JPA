package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrderDTO {
    private Long orderId;
    private String productName;
    private LocalDateTime orderDate;
    private String customerName;  // 고객 이름만 노출

    // 생성자
    public OrderDTO(Long orderId, String productName, LocalDateTime orderDate, String customerName) {
        this.orderId = orderId;
        this.productName = productName;
        this.orderDate = orderDate;
        this.customerName = customerName;
    }

    // getter/setter 생략 가능 (Lombok 사용 가능)
}
