package com.example.queryDSL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "acorntbl_querydsl")
public class Member {
    @Id
    String id;
    String pw;
    String name;
    String grade;
}
