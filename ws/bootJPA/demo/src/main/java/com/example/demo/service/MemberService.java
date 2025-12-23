package com.example.demo.service;


import com.example.demo.repository.MemberRepository;
import com.example.demo.domain.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {


    MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<MemberResponse> getMemberList(){
        return  repository.findAll().stream().map( MemberResponse::new ).collect(Collectors.toList());

    }

/*
    public List<MemberResponse> getMemberList2(){
         List<Member>  list=   repository.findAll();

         List<MemberResponse> list2 = new ArrayList<>();
         for( Member member: list){
             MemberResponse memberResponse  = new MemberResponse( member);
             list2.add(memberResponse);

         }

         return  list2;

    }

 */
}
