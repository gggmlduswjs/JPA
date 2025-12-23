package com.acorn.BoardJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;



@Transactional
@SpringBootTest
class UserRepositoryTest {



    @Autowired
    UserRepository repository;
    //

    @Test
    public  void test(){

       User user  =  repository.findById("user1").orElse(null);
       System.out.println( user);

    }

}