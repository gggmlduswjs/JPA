package com.example.jpaDay01.optional;

import java.util.Optional;

public class MyLib {
    
    // 매서드 멤버를 반환하는 Member

    public Member getMember(String id) {
        //
        Member member = null;
        member = new Member();
        member.setId("acorn");
        member.setName("이제훈");

        return member;
    }
     
    
    // 매서드 멤버를 반환하는 Optional<Member>
    public Optional<Member> getMemberOptional(String id){
        Member member=null;
//        member=new Member();
//        member.setId("acorn");
//        member.setName("이제훈");
        return Optional.ofNullable(member);
    }


    
}
