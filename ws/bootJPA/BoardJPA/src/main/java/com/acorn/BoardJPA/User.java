package com.acorn.BoardJPA;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class User {
    @Id  // PK로 지정
    @Column(name="user_id")
    private String id;
    private String password;
    private String name;
    private String email;


    // FetchType.EAGER - 두 엔티티의 정보를 같이 가져오는것(join)
    // FetchType.LAZY - 따로 가져오는 것. 나중에 getList(). default


   // @OneToMany(mappedBy = "user", fetch= FetchType.LAZY)
    //!!! mappedBy에는 연관관계의 주인  Board의 연관된 객체 user을 적어야 한다
    @OneToMany(mappedBy = "user")
   List<Board> list = new ArrayList<>();


    public List<Board> getList() {
        return list;
    }

    public void setList(List<Board> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", list=" + list +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
