package com.example.queryDSL;


import com.querydsl.core.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class MemberService {

    @Autowired
    MemberRepository repository;

    public List<Member> getMemberList(){
        return  repository.findalldsl();
    }
    public List<Member> getMemberList2(){
        List<Member> result= repository.findalldsl2();
        log.info("조회 결과: {}", result);
        return result ;
    }

    public List<MemberGroupDTO> findMemberCountByGrade() {
        List<MemberGroupDTO> result = repository.findMemberCountByGrade();

        System.out.println( result);
        return  result;
    }

    public List<GradeCountDto> findMemberCountByGrade2() {
        List<GradeCountDto> result = repository.findMemberCountGroupedByGrade2();

        System.out.println( result);
        return  result;
    }


    //
    public List<Member> getMemberList동적쿼리(String id, String name, String grade){
        return  repository.searchMembers(id, name, grade);
    }

}
