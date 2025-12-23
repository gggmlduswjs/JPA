package com.example.queryDSL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository   extends JpaRepository<Member, String> , MemberRepositoryCustom {

    @Query("SELECT new com.example.queryDSL.GradeCountDto(m.grade, COUNT(m.id)) " +
            "FROM Member m GROUP BY m.grade")
    List<GradeCountDto> findMemberCountGroupedByGrade2();


}
