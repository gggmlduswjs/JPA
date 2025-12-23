package com.acorn.BoardTest;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BoardService {


    @Autowired
    BoardRepository repository;

    //전체글 조회
    public List<Board> getSelectAll(){

        return  repository.findAll();

    }

    //글 작성
    //글수정
    public  Board write( Board board){
        return  repository.save(board);
    }



    //글번호로 조회
    public Board  read( Long bno){
        return  repository.findById(bno).orElse(null);
    }


    //글삭제

    public void remove( Long bno){
        repository.deleteById(bno);
    }


}
