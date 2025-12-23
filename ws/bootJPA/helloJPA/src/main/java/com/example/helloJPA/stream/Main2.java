package com.example.helloJPA.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {


        // 변환하기
        // 엔티티를   response객체로 변환하기

        List<Member> members = List.of(
                new Member("홍길동", 25),
                new Member("김철수", 18),
                new Member("이영희", 30)
        );

        List<MemberResponse> memberResponseList = members.stream()
                .map( item  ->{ return new MemberResponse(  item);})
                .toList();
                //.collect(Collectors.toList());

        System.out.println(memberResponseList); // [홍길동, 이영희]


    }
}
