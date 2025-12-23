package com.example.demo.repository;


import com.example.demo.domain.GradeCount;
import com.example.demo.domain.GradeCountDto;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    
    //고객등급별 고객 수 구하기
    //GradeCount 인터페이스 작성
    //앨리아스 기준으로 getter 작성
    //인터페이스를 기반으로 객체를 자동으로 생성해 준다

    @Query("SELECT c.grade AS grade, COUNT(c) AS count FROM Customer c GROUP BY c.grade")
    List<GradeCount> countCustomersByGrade();


    
    //쿼리결과를 GradeCountDto에 담아 준다
    @Query("SELECT new com.example.demo.domain.GradeCountDto(c.grade, COUNT(c)) FROM Customer c GROUP BY c.grade")
    List<GradeCountDto> countCustomersByGrade2();

}
