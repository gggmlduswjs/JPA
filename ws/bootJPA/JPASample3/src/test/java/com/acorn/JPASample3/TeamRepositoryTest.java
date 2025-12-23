package com.acorn.JPASample3;

import jakarta.persistence.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
class TeamRepositoryTest {



    @Autowired
    TeamRepository repository;

    // 팀정보 조회
    // 팀의 소속된 멤버들도 조회됨
    @Test
    public  void  test(){


        Team team =  repository.findById(1l).orElse(null);
        System.out.println( team);
        System.out.println( team.getMembers());




    }
}