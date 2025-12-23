package com.acorn.JPASample3;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@Entity
@Table(name = "acorn_member3")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  name;


    @JsonIgnore                          //  팀으로 조회시 순환참조발생으로   포함시키지 말 것
    @ManyToOne                           // 회원은 한 팀에 속함  (다 : 일)
    @JoinColumn(name = "team_id" ,nullable = false)       // 'team_id' 컬럼을 통해 관계 설정 , 외래키설정
    private Team team;

    // Getter, Setter

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='"  + name + '\'' +
               // ", team=" + team +   // 팀으로 조회시 순환이 발생하지 않도록
                '}';
    }
}

