package com.acorn.hiJpa;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "acorntbl_jpa")  // 테이블 이름을 acorntbl로 설정
public class Member {

       @Id              //테이블의 pk와 매핑
      String id;  // id 타입을 String으로 변경

      String pw;
      String name;


    // MemberRequest -> Member 객체로 만들어 줌
    // 입력정보는 MemberDTO를 사용
    // 생성자 오버로딩을 사용할 수 있다

    public static Member createMember(MemberRequest memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setPw(memberDTO.getPw());
        member.setId( memberDTO.getId());
        return member;
    }


}
