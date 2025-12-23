package com.acorn.BoardJPA;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {

    // JPQL을 사용한 조인 쿼리
    //Board테이블에서 특정 사용자의 게시글 조회하기
    @Query("SELECT b FROM Board b JOIN b.user u WHERE u.id = :userId")
    List<Board> findaaBoardsByUserId(@Param("userId") String userId);

    //쿼리매서드
    List<Board> findByUserId(String  userId);


    //글제목으로 게시글  조회하기
    //쿼리매서드 작성규칙
    List<Board> findByTitleContaining(String title);

    //글제목으로 게시글 조회
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:title%")
    List<Board> findBoardsByTitleContaining(@Param("title") String title);


}