package com.acorn.JPASample3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
  //  @Query("SELECT m FROM Member m JOIN  m.team WHERE m.team.name = :teamName")
 //  List<Member> findByTeamName(@Param("teamName")String teamName);

    List<Member> findByTeamName(String teamName);

}


/*
sql 예시


SELECT m.*
FROM membertbl m
JOIN teamtbl  t ON m.team_id = t.id
WHERE t.name =  ?;

 */



/*

쿼리매서드이지만
조건이 연관 엔티티의 필드(Team.name) 에 걸림
JPA는 Member만 조회해서는 조건을 만족시킬 수 없으므로
내부적으로 JOIN (INNER JOIN) 을 만들어서
Member와 Team을 조인한 상태에서 조건을 적용함
따라서, 한 번의 JOIN 쿼리로 멤버와 팀 모두 조회됨

요약하면
JPA에서는 조회 조건이 직접 외래키 컬럼에 걸리는 경우에는 조인 없이 단순 쿼리가 실행되고,
조건이 연관 엔티티의 속성에 걸릴 경우 JPA가 내부적으로 JOIN 쿼리를 생성한다.
따라서 상황에 따라 단일 쿼리 또는 조인 쿼리가 자동으로 선택된다.
 */