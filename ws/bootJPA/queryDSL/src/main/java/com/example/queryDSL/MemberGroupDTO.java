package com.example.queryDSL;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
