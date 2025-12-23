package com.acorn.hiJpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {


 
    //쿼리매서드 제공
    //SELECT * FROM acorntbl_jpa WHERE name LIKE '%입력값%';
    List<Member> findByNameContaining(String name );
    Page<Member> findByNameContaining(String name, Pageable pageable);


    //List<Member> findByName(String name);
    //JPQL 작성
    // sql
    // select * from acorntbl_jpa   where  name =?
    //SELECT * FROM acorntbl_jpa WHERE name LIKE CONCAT('%', ?, '%');
    //SELECT * FROM acorntbl_jpa WHERE name LIKE '%값%';


    //  작성한  sql  =>  jpql
   // @Query(value = "SELECT m  FROM Member  m   WHERE m.name = :name ")
    @Query("SELECT m FROM Member m WHERE m.name LIKE %:name%")
    List<Member> findBy22222(@Param("name") String name );


}