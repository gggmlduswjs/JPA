package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders") // 'order'는 예약어라서 테이블명은 'orders' 추천
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private LocalDateTime orderDate;

    //연관관계 매핑
    //주문  - 고객
    //Many to  One
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id") // FK 컬럼 , customer_id 라는 fk 생김
    private Customer customer;

    // 생성자
    public Order() {}

    public Order(String productName, LocalDateTime orderDate, Customer customer) {
        this.productName = productName;
        this.orderDate = orderDate;
        this.customer = customer;
    }


}
