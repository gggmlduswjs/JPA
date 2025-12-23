package com.acorn.hiJPA2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Table(name = "acorntbl_jpa2")  // 테이블 이름을 acorntbl로 설정
@Entity
public class Member {


    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



     //팀정보
    //연관관계 설정
    //Member테이블에   team_id  외래키 생성됨
    @ManyToOne ( fetch =  FetchType.LAZY)
    @JoinColumn(name="team_id", nullable = false) // 테이블의 조인컬럼명과 같아야 함
    Team team ;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                 ", team=" + team +
                '}';
    }
}
