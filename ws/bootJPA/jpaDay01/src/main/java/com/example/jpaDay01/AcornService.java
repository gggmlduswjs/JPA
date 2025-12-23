package com.example.jpaDay01;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 엔티티매니저 (영속성컨텍스트) -> 영속성컨텍스트에 엔티티 정보를 저장하면  -> 데이터 베이스에 insert 쿼리 자동발생


// 꼭 추가하기
// 엔티티 저장하거나 변경할 때는 트랜잭션이 필요하다!!
// 엔티티가 변경되면 변경감지 -> update 쿼리 발생시킨다
@Transactional
@Service
public class AcornService {
    
    // repository 주입받기

    private  final AcornRepository repository;

    // 생성자 주입
//    @Autowired 생략가능
    public AcornService(AcornRepository repository) {
        this.repository = repository;
    }

    // 전체조회
    public List<Acorn> getAcornList() {

        return repository.findAll();
    }

    
    
    // 한 개 조회
    public Acorn getAcornOne(String id) {
        return repository.findById(id).orElseThrow();
    }




    //등록하기
    public  void  register( ){

        Acorn acorn = new Acorn(); //엔티티 객체 생성
        acorn.setId("honghong");
        acorn.setName("홍길동");
        acorn.setPoint(3000);
        acorn.setPw("1234");

        repository.save( acorn);   //데이터베이스에 저장하기

    }

     
    // 변경하기

    public void modify() {

        // 회원찾기 (victoai)
        // 회원정보변경, 포인터변경, 비번변경
        String id="victoai";
        Acorn acorn =repository.findById(id).orElseThrow();
        acorn.setPoint(50000);
        acorn.setPw("9999");

    }
    
    // 삭제하기

    public void deleteAcorn(String id) {

        repository.deleteById(id); //
    }

    // 김씨 ~ 조회
    public Acorn getAcornName(String name) {

        return repository.findByName(name).orElseThrow();
    }

    public List<Acorn> getAcornListName(String lastName){

        return repository.findByNameStartingWith(lastName); //김
    }


    //이름조회하기 jpql

    public  Acorn  getAcornNameJPQL( String name){
        return  repository.aaa(name).orElseThrow();
    }


    // 페이징쿼리

    // Page - 리스트, 전체 페이지수
    public Page<Acorn> getAcornListPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

}
