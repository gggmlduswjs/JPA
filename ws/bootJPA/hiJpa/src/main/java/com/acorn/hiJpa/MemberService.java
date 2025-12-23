package com.acorn.hiJpa;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class MemberService {


    @Autowired
    MemberRepository repository;

    //회원 등록
    public Member register( MemberRequest memberRequest){


        //엔티티 생성
       /* Member m = new Member();
        m.setId(member.getId());
        m.setPw(member.getPw());
        m.setName(member.getName());
      */
        Member memberEntity = Member.createMember(memberRequest);
        Member saveMember = repository.save(memberEntity);
        return saveMember;
    }



    //회원 전체 조회
    public List<Member>  getMemberList(){
        List<Member> list  = repository.findAll();
        return  list;
    }

    //회원 전체 조회
    public List<MemberResponse> getMemberList2() {
        return repository.findAll()
                .stream()
                .map(m -> new MemberResponse(
                        m.getId(),
                        m.getName(),
                        m.getPw()
                ))
                .toList();
    }

    //회원상세 조회
    public Member getMember(String id) {

        Member member = repository.findById( id).orElse(  null);

        //Optional  객체 반환
       /*
        Optional<Member> optional = repository.findById(id);
        Member member = optional.orElse(new Member());  //
        */

        return  member;

    }



    //회원변경
    //변경감지
    @Transactional
    public void  modifyMember( String id, String newpw){

        Optional<Member> optional = repository.findById(id);
        Member member =null;
        if(optional.isPresent()){
            member = optional.get();  //엔티티의 값이 변경되면 update 쿼리발생, 단 @Transactional 애너테이션 필요
            member.setPw(newpw);
           // repository.save(member);
        }


        log.info("변경: {}", newpw);

    }


    //회원 삭제하기
    public void  deleteMemberById(String id){
        repository.deleteById( id);
    }



    //이름이 포함된 회원 조회하기
    //쿼리매서드 사용하기
    public List<Member> getMembersByName(String name ) {
        //쿼리매서드 사용
        return repository.findByNameContaining(name);
    }


    //이름이 포함된 회원조회하기
    //jpql로 작성하기
    public List<Member> getMembersByNameJPQL(String name ) {
        return repository.findBy22222(name);
    }



    //페이징 처리 , 별도로 할 필요없음 
    //페이지는 0부터 시작함, 주의 !

    public Page<Member> getMembersByName(String name, int page, int size) {
           Pageable pageable = PageRequest.of(page, size);
           return repository.findByNameContaining(name, pageable);
    }



    public Page<Member> findAll(  int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }


    

}
