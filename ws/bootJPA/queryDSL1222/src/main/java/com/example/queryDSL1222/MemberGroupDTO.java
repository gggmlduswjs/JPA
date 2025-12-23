package com.example.queryDSL1222;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor


@Data
public class MemberGroupDTO {
    String grade;
    Long count;



     @QueryProjection
    public MemberGroupDTO(String grade, Long count) {
        this.grade = grade;
        this.count = count;
    }

}
