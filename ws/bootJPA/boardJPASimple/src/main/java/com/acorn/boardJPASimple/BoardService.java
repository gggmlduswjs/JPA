package com.acorn.boardJPASimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//영속상태: 엔티티매니저에 의해서 저장되거나 조회되면 영속성관리됨 (영속성 컨텍스트에 저장됨)


@Transactional
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    // 전체 게시물을 가져오는 메서드
    public List<Board> getList(){
        return (List<Board>) boardRepository.findAll();
    }
    // 게시물 작성하는 메서드
    public Board write(Board board){
        return boardRepository.save(board);
    }
    // 게시물을 읽어오는 메서드
    public Board read(Long bno) {
        return boardRepository.findById(bno).orElse(null);
    }



    public Board modify(Board newBoard) {
        // 새로운 board 객체를 찾아서 수정할 객체를 가져온다
        Board board = boardRepository.findById(newBoard.getBno()).orElse(null);
        if (board == null) return null;

        // 새로운 값으로 기존 board 객체의 속성들을 변경
        board.setTitle(newBoard.getTitle());
        board.setContent(newBoard.getContent());

        // 엔티티의 상태 변경이 영속성 컨텍스트에 의해 추적 됨
        // 변경 감지 기능에 의해 트랜잭션이 커밋될 때 자동으로 업데이트가 반영
        // 하지만 명시적으로 save()를 호출하는 것이 일반적인 방법이다
        boardRepository.save(board);  // 명시적으로 저장하는 것이 더 일반적입니다.
        return board;
    }


    // 게시물을 삭제하는 메서드
    public void remove(Long bno){
        Board board = boardRepository.findById(bno).orElse(null);
        if(board!=null)
            boardRepository.deleteById(bno);
    }



    // 사용자 ID로 게시글을 조회하는 서비스 메서드
    //  JPQL 작성
    public List<Board> getBoardsByUserId(String userId) {

    return boardRepository.findaaBoardsByUserId(userId);
    }
    
    
    // 사용자 ID로 게시글을 조회하는 서비스 메서드
    // 쿼리매서드 작성
    public List<Board> getBoardsByUserId2(String userId) {
        return boardRepository.findByUserId(userId);
    }



    //제목으로 조회 , 쿼리매서드 사용
    public  List<Board> getBoardsByTitle(String title){
        return  boardRepository.findByTitleContaining(title);
    }


    //제목으로조회 ,JPQL 작성
    public List<Board> getBoardsByTitle2( String title){
        return  boardRepository.findBoardsByTitleContaining(title);
    }
}
