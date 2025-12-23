package com.example.queryDSL1222;

import java.util.List;

public interface MemberRepositoryCustom {


    List<Member> findalldsl();
    List<Member> findalldsl2();
    List<MemberGroupDTO> findMemberCountByGrade();

    //동적쿼리 예시
    List<Member>   searchMembers( String id, String name, String grade);


}
