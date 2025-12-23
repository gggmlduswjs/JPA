package com.acorn.hiJPA2;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//@ManyToOne(fetch = LAZY) 인 경우는 아래 jsonIgnoreProperties설정해야 함 !!
//"Hibernate가 만들어준 가짜 객체 안의 복잡한 정보는 무시하고 JSON 만들자"
 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Team {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
