package com.example.helloJPA.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final List<Member> members = new ArrayList<>();

    // 초기 데이터 삽입
    public MemberService() {
        members.add(new Member(1L, "홍길동", "hong@test.com"));
        members.add(new Member(2L, "김철수", "kim@test.com"));
    }

    // 이메일로 조회
    public Optional<Member> findByEmail(String email) {
        return members.stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

    // 회원 이름 가져오기
    public Optional<Member> findByName(String name) {
        return members.stream()
                .filter( m-> m.getName().equals(name))             // 값이 있으면 이름 반환
                .findFirst( );                // 없으면 기본값 반환
    }

}
