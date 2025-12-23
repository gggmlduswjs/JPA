package com.acorn.hiJPA2;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member, Long> {

    
    //팀아이디로 팀에 소속된 멤버 조회하기
    //쿼리가 n+1로 만들어진다
    //물론 영속성컨텍스에 쿼리의 결과가 있으므로 같은 쿼리가 반복
    List<Member> findByTeamId(Long teamId);    // Team객체의 id로 조회
     //SELECT  m FROM Member m WHERE m.team.id = :teamId
     //"SELECT m FROM Member m JOIN   m.team t WHERE t.id = :id"



    //팀 아이디로 팀에 소속된 멤버 조회하기
    //fetch조인을 하면 쿼리가 한 개만들어 지고 실행된다.
    @Query("SELECT m FROM Member m JOIN FETCH m.team t WHERE t.id = :id")
    List<Member> findMembersTeamFetch(@Param("id") Long teamId);

}
