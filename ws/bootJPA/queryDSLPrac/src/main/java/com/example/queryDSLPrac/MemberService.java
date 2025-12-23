package com.example.queryDSLPrac;

import com.querydsl.core.Tuple;
import jakarta.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository repository;


    public List<Tuple> findMemberCountByGrade(){
        List<Tuple> result  = repository.findMemberCountByGrade();





        return  result;
    }
}
