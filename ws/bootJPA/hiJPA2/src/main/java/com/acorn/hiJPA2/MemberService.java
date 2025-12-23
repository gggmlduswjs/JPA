package com.acorn.hiJPA2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {


    @Autowired
    MemberRepository repository;

    //멤버전체조회
    public List<Member> getMembers(){
       return  repository.findAll();
    }
    
    
    // 특정 멤버조회
    // 멤버조회하면 팀정보를 얻어 올 수 있다
    public Member getMember(Long id) {
        Optional<Member> optional = repository.findById(id);
        if (optional.isPresent()) {
            Member member  = optional.get();
            //System.out.println( "멤버아이디"+ member.getId()  + "소속팀"+ member.getTeam());
            return member;
        } else {
            throw new RuntimeException("  ID " + id + " not found");
        }
    }





    //멤버등록
    public Member register( Member member){
        return repository.save(member);
    }




    //팀아이디로 팀원 목록 조회하기
    public List<Member> getMembersByTeam(Long team_id) {
        return repository.findByTeamId(team_id);
    }
    
 

    //팀아이디로 팀원 목록 조회하기
    //fetch 조인 사용하기

    public List<Member > getMembersByTeam2
            (Long team_id) {
        return repository.findMembersTeamFetch(team_id);

    }









}
