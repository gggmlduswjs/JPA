package com.example.helloJPA.optional;

import java.util.Optional;

public class MemberOptionalTest {
    public static void main(String[] args) {
        MemberService service = new MemberService();

        Optional<Member> memberOptional0 = service.findByName("홍길동");

        //ifPresent
        memberOptional0.ifPresent( ( m)->  System.out.println(m) ); // 값이 있으면 출력




        // 2. 값이 없으면 예외 발생
        Member member02 = service.findByName("김철수")
                .orElseThrow(() -> new RuntimeException("회원이 없습니다"));

        System.out.println(member02);


        Optional<Member> memberOptional2 = service.findByName("홍길동");

        if (memberOptional2.isPresent()) {
            Member member03 = memberOptional2.get(); // 값이 존재할 때만 get() 가능
            System.out.println(member03);
        }



        Member member = service.findByEmail("kimjj@test.com")
                .orElse(  new Member(0L, "기본 회원", "default@test.com")     );
        System.out.println("회원 이름: " + member.getName());





        //“값이 없으면 Supplier가 실행되어 예외 객체가 생성되고, 그 예외가 즉시 throw 된다.”
        try {
            Member member2 = service.findByEmail("kimjj@test.com")
                    .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다"));
            System.out.println("회원 이름: " + member2.getName());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }



    }
}
