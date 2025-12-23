package com.example.helloJPA.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {


        //

        List<Member> members = List.of(
                new Member("홍길동", 25),
                new Member("김철수", 18),
                new Member("이영희", 30)
        );

        List<String> names = members.stream()
                .filter(m -> m.getAge() >= 20)   // 조건
                .map(Member::getName)            // 변환
                .collect(Collectors.toList());

        System.out.println(names); // [홍길동, 이영희]


    }
}
