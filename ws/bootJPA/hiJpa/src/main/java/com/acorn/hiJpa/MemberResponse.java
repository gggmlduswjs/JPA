package com.acorn.hiJpa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberResponse {
    String id;  // id 타입을 String으로 변경

    String pw;
    String name;
}
