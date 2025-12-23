package com.acorn.hiJpa;


//회원정보를 저장할 클래스

public class MemberRequest {




    //@NotBlank(message =  " 이름  입력해 주세요")
    private String id;  // id 타입을 String으로 변경
    private String pw;
    private String name;

    // 기본 생성자
    public MemberRequest() {}

    // 모든 필드를 초기화하는 생성자
    public MemberRequest(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public MemberRequest(Member member) {
        this.id = member.id;
        this.pw = member.pw;
        this.name = member.name;
    }

    // Getter, Setter 메서드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
