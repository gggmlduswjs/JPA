package com.acorn.JPASample3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private  MemberService memberService;


    // 멤버 ID로 회원 조회

    @GetMapping("/members")
    public List<Member> getMembers()  {
        List<Member> list= memberService.findMemberAll();
        return  list;
    }


    // 멤버 ID로 회원 조회

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable(name="id") Long id) {
        Member member= memberService.findMemberById(id);
        System.out.println( "조회된 멤버 " +member.getTeam().getName());
        return  member;
    }


    // 팀 이름으로 멤버 조회 API
    @GetMapping("/members/team-name/{teamName}")
    public List<Member> getMembersByTeamName(@PathVariable(name="teamName") String teamName) {

        System.out.println(  teamName);
        List<Member> list = memberService.findMembersByTeamName(teamName);
        System.out.println( list);
        return memberService.findMembersByTeamName(teamName);
    }




}

