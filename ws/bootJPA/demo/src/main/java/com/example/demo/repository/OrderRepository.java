package com.example.demo.repository;



import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 고객 등급별로 주문 조회
    @Query("SELECT o FROM Order o JOIN o.customer c WHERE c.grade = :grade")
    List<Order> findOrdersByCustomerGrade(@Param("grade") String grade);

    // 고객 ID로 주문 조회
    List<Order> findByCustomerId(Long customerId);

    // 특정 상품을 주문한 모든 주문 조회
    List<Order> findByProductName(String productName);

    // 주문일이 특정 날짜 이후인 주문 조회
    List<Order> findByOrderDateAfter(java.time.LocalDateTime date);
}
