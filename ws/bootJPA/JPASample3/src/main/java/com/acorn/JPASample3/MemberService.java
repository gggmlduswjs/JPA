package com.acorn.JPASample3;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @Autowired
    private   MemberRepository memberRepository;


    public  List<Member> findMemberAll(){
        return  memberRepository.findAll();
    }


    // 고객 ID로 고객 정보 조회
    public Member findMemberById(Long id) {
        Optional<Member> optional = memberRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Member not found with id: " + id);
        }
    }


    // Team 이름으로 Member리스트 조회
    public List<Member > findMembersByTeamName(String teamName) {
        return memberRepository.findByTeamName(teamName );

    }






}
