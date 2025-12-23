package com.acorn.hiJPA2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {


    @Autowired
    MemberService service;


    //전체 회원 조회
    @ResponseBody
    @GetMapping("/members")
    public List<Member> getMemers(){
        return  service.getMembers();
    }


    // 특정 회원 조회
    @ResponseBody
    @GetMapping("/members/{id}")
    public  Member  getMemer(@PathVariable (name = "id") Long id){
        Member member= service.getMember(id);
        System.out.println( member);
        //System.out.println( "현재회원의 팀정보 " +member.getTeam() );
        return member;
    }


    //회원저장
    //이때 팀정보가 필요하다

    @ResponseBody
    @GetMapping("/members/save")
    public  Member  register(){

        Team team = new Team();
        team.setId(1l);
        team.setName("우동훈조");

        Member member = new Member();
        member.setName("브래드피트");
        member.setTeam(team);

        return  service.register( member);
    }



    //팀으로 조회하기
    //1)쿼리매서드 사용하기
    //2)fetch 조인 jpql 사용하기  => 조인쿼리 한 개로 조회하기
    // => 두 개의 차이를 테스트에서 확인하기 !!
    @ResponseBody
    @GetMapping("/members/team/{teamId}")
    public  List<Member>  getMemersTeam(@PathVariable (name = "teamId") Long teamId){
        List<Member> list= service.getMembersByTeam(teamId);
        System.out.println( list);
        return list;
    }

    //팀으로 조회하기
    @ResponseBody
    @GetMapping("/members/team-join/{teamId}")
    public List<Member> getMembersByTeamId(@PathVariable(name="teamId") Long teamId) {
        List<Member> list = service.getMembersByTeam2(teamId);
        System.out.println( list);
        return service.getMembersByTeam2(teamId);
    }



}
