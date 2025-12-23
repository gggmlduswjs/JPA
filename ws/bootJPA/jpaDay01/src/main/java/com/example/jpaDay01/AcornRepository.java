package com.example.jpaDay01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


// @Repository 생략 가능함
public interface AcornRepository extends JpaRepository <Acorn, String> {


    // 쿼리 매서드(매서드의 이름으로 쿼리를 작성해줌)
    // 매서드 이름의 규칙이 있음
    Optional<Acorn> findByName(String name);
//    List<Acorn> findByNameStartingWith(String name);  // like name '김%'
    List<Acorn> findByNameStartingWith(String name);


    // select * from acorntbl_jpa_test where name=? jpal로 바꿔줘
    // 이름으로 조회하기를 jpql로 작성하기
    // jpql제공 (엔티티를 대상으로 쿼리를 작성함)
    // 매서드 이름 마음대로 (의미만 부여해서 만들기)

    @Query("select a from Acorn a where a.name = :name" )
    Optional<Acorn>  aaa(@Param("name") String name);



}
