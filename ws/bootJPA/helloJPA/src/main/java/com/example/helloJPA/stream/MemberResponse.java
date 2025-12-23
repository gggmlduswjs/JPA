package com.example.helloJPA.stream;

import lombok.Data;

@Data
public class MemberResponse {

    private String name;
    private int age;



    public  MemberResponse( Member member){
        this.name  = member.getName();
        this.age = member.getAge();
    }
}
