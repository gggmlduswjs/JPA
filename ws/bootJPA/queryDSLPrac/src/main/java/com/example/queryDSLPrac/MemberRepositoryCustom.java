package com.example.queryDSLPrac;

import com.querydsl.core.Tuple;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Tuple> findMemberCountByGrade();
}
