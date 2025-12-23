package com.acorn.hiJPA2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService service;


   @Test
    void test1(){
        List<Member> list  = service.getMembersByTeam(1l);
        System.out.println( list);
    }

  //  @Test
    void test2(){
        List<Member> list  = service.getMembersByTeam2(1l);
        System.out.println( list);
    }
}