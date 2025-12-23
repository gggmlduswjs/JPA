package com.example.queryDSL1222;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.queryDSL1222.QMemberGroupDTO is a Querydsl Projection type for MemberGroupDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberGroupDTO extends ConstructorExpression<MemberGroupDTO> {

    private static final long serialVersionUID = -768404799L;

    public QMemberGroupDTO(com.querydsl.core.types.Expression<String> grade, com.querydsl.core.types.Expression<Long> count) {
        super(MemberGroupDTO.class, new Class<?>[]{String.class, long.class}, grade, count);
    }

}

