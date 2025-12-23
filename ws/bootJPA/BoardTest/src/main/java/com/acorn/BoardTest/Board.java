package com.acorn.BoardTest;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno; // 게시물 번호
    private String title;
    private String content;
    private Long viewCnt;

    @Temporal(value= TemporalType.TIMESTAMP)
    private Date inDate;
    @Temporal(value= TemporalType.TIMESTAMP)
    private Date upDate;



    @ManyToOne
    @JoinColumn( name="user_id" , nullable = false)
    private  User user;

    public Long getBno() {
        return bno;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getViewCnt() {
        return viewCnt;
    }

    public User getUser() {
        return user;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setViewCnt(Long viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getInDate() {
        return inDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                ", user=" + user +
                '}';
    }
}
