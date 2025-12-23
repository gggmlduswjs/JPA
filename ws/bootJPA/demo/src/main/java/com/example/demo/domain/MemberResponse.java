package com.example.demo.domain;

import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdDate;



    public  MemberResponse( Member member){

        this.id  = member.getId();
        this.username = member.getUsername();
        this.password   = member.getPassword();
        this.email  = member.getEmail();
        this.createdDate = member.getCreatedDate();


    }
}
