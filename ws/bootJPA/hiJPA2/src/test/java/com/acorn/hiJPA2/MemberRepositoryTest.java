package com.acorn.hiJPA2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {



    @Autowired
    MemberRepository repository;

    @Test
    public  void  test(){

         Member memeber= repository.findById(1l).orElse(null);

         System.out.println( memeber);


    }
}