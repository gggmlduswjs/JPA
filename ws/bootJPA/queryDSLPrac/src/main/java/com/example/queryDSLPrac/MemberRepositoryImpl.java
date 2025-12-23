package com.example.queryDSLPrac;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberRepositoryImpl  implements  MemberRepositoryCustom{

    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    @Override
    public List<Tuple> findMemberCountByGrade() {

        QMember member = QMember.member;


        return  jpaQueryFactory.select(member.grade.as("grade" ), member.id.count().as("count"))
                .from(member)
                .groupBy( member.grade)
                .fetch();
    }
}
