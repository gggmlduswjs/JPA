package com.example.demo.domain;

import lombok.Data;

@Data
public class GradeCountDto {
    private String grade;
    private Long count;

    public GradeCountDto(String grade, Long count) {
        this.grade = grade;
        this.count = count;
    }

    // Getter 생략 가능 (Lombok 사용 가능)
}
