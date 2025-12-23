package com.example.jpaDay01.optional;

import java.util.Optional;

public class MyLibMain {

    public static void main(String[] args) {

        MyLib lib = new MyLib();
        
        // null 체크 강제하지 않음, 멤버가 없는 경우 null 반환 시 오류 발생

//        Member member =lib.getMember("test");

//        System.out.println(member.getName());

        Optional<Member> memberOptional =lib.getMemberOptional("acorn");
        if(memberOptional.isPresent()){
            Member member =memberOptional.get();
            System.out.println(member.getName());
        }

//        Optional<Member> memberOptional2 =lib.getMemberOptional("acorn");
//        Member member2=memberOptional2.orElseThrow();
//        System.out.println(member2.getName());

        try {
            Optional<Member> memberOptional3 = lib.getMemberOptional("acorn");
            Member member3 =memberOptional3.orElseThrow(()-> {
                return new RuntimeException("회원이 존재하지 않는다");
            });

            System.out.println(member3.getName());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
       System.out.println("^^");

    }
}
