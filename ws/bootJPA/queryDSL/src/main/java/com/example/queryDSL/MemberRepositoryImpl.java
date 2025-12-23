package com.example.queryDSL;
import com.example.queryDSL.Member ;
import com.example.queryDSL.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    //QueryDSL(JPA용)에서 제공하는 클래스
    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Member> findalldsl() {
        QMember member = QMember.member;

        return jpaQueryFactory
                .selectFrom(member)
                .fetch(); // 조건 없이 전체 조회
    }
    @Override
    public List<Member> findalldsl2() {
        QMember member = QMember.member;

        return jpaQueryFactory
                .selectFrom(member)
                .where(member.name.startsWith("김"))
                .fetch(); // 이름이 '김'으로 시작하는 사람만 조회

    }




    /*
    @Override
    public List<MemberGroupDTO> findMemberCountByGrade() {
        QMember member = QMember.member;

        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberGroupDTO.class,
                        member.grade,
                        member.id.count()
                ))
                .from(member)
                .groupBy(member.grade)
                .fetch();
    }
*/

    @Override
    public List<MemberGroupDTO> findMemberCountByGrade() {
        QMember member = QMember.member;   // 엔티티 Q타입

        return jpaQueryFactory
                .select(new QMemberGroupDTO(member.grade, member.id.count()))
                .from(member)
                .groupBy(member.grade)
                .fetch();
    }



    @Override
    public List<Member> searchMembers(String id, String name, String grade) {
        QMember member = QMember.member;

        BooleanBuilder builder = new BooleanBuilder();

        if (id != null && !id.isEmpty()) {
            builder.and(member.id.eq(id));
        }
        if (name != null && !name.isEmpty()) {
            builder.and(member.name.contains(name)); // 이름 부분 검색
        }
        /*

        contains("홍") → '%홍%'
        startsWith("홍") → '홍%'
        endsWith("홍") → '%홍'

         */
        if (grade != null && !grade.isEmpty()) {
            builder.and(member.grade.eq(grade));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();


        /*

        SELECT *
        FROM member;


        SELECT *
        FROM member
        WHERE name LIKE '%김%';



        SELECT *
        FROM member
        WHERE id = 'acorn01'
          AND name LIKE '%홍%'
          AND grade = 'A';

         */
    }

}

