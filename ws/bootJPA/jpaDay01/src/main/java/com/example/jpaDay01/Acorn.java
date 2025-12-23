package com.example.jpaDay01;


// 테이블과 매핑될 객체 => entity(엔티티)

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acorntbl_jpa_test")
public class Acorn {
    
    // 키 컬럼
    @Id
    String id;

    String name;
    String pw;
    Integer point;

    // 생성자

    public Acorn() {
    }

    public Acorn(String id, String name, String pw, Integer point) {
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.point = point;
    }

    // setter // getter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }


    // toString


    @Override
    public String toString() {
        return "Acorn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                ", point=" + point +
                '}';
    }
}
