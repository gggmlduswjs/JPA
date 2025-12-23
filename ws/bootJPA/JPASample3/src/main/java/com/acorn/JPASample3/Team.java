package com.acorn.JPASample3;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    //@JsonIgnore   //team 정보를 만들 때  멤버리스트는 포함하지 않는다 , 순환참조발생
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members = new ArrayList<>();


    /*
     ## 연관관계 편의 매서드

    // 팀에 회원을 추가하는 메서드
    public void addMember(Member member) {
        members.add(member);
        member.setTeam(this);  // 양방향 관계를 관리
    }

    // 팀에서 회원을 삭제하는 메서드
    public void removeMember(Member member) {
        members.remove(member);
        member.setTeam(null);  // 양방향 관계를 관리
    }

    // 팀의 회원을 모두 삭제하는 메서드
    public void clearMembers() {
        for (Member member : members) {
            member.setTeam(null);  // 양방향 관계 관리
        }
        members.clear();
    }
*/

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                 ", members=" + members +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
