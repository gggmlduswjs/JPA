package com.example.queryDSLPrac;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String >  , MemberRepositoryCustom {
}
