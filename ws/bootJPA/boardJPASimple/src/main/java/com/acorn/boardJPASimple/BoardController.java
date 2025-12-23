package com.acorn.boardJPASimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    //게시글 전체 조회하기
    @GetMapping("/list")
    public String getList(Model model){
        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "list";
    }



    //글 작성하기
    @GetMapping("/write")
    public String showWriteForm(Model model){
        Board board = new Board();
        //로그인한 사용자 정보
        User user = new User();
        user.setId("user1");
        board.setUser(user);

        model.addAttribute("board", board);
        return "write";
    }


    //등록과 수정시 사용

    @PostMapping("/write")
    public String write(Board board){
        board.setViewCnt(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());
        boardService.write(board);
        return "redirect:/board/list"; // 글을 삭제한 다음에는 게시물 목록으로 이동
    }



    //글 수정하기
    @GetMapping("/modify")
    public String modify(@RequestParam ("bno") Long bno, Model model){
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "write";
    }


    //글 삭제하기
    @PostMapping("/remove")
    public String remove(@RequestParam (name="bno") Long bno){
        boardService.remove(bno);
        return "redirect:/board/list"; // 게시물 삭제후에 게시물 목록으로 이동
    }


    //글번호로 게시글 조회하기
    @GetMapping("/read")
    public String read(@RequestParam(name="bno") Long bno, Model model){
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "read";  // read.html을 뷰로 사용.
    }






    //########################################################################################
    // 특정 사용자의 게시글 조회
    // JPQL 작성하기
    @ResponseBody
    @GetMapping("/user")
    public List<Board> getBoardsByUser(@RequestParam( name="userId") String userId )   {
        List<Board> list  = boardService.getBoardsByUserId( userId);
        //Board객체의 user정보를 확인하면 user정보가 들어가 있는것을 확인할 수 있다
        System.out.println( list.get(0).getUser().getEmail());
        return list;
    }


    // 특정 사용자의 게시글 조회
    // 쿼리매서드사용하기
    @ResponseBody
    @GetMapping("/user2")
    public List<Board> getBoardsByUser2(@RequestParam("userId") String userId ) {
        // 서비스에서 특정 사용자의 게시글 리스트 가져오기
        return  boardService.getBoardsByUserId2(userId);
    }



    @GetMapping("/title")
    public  String  getBoardsByTitle(@RequestParam("title") String title  , Model model) {
        // 서비스에서 특정 사용자의 게시글 리스트 가져오기
        List<Board> list  = boardService.getBoardsByTitle(title);
        model.addAttribute( "list", list);
        return "list";
    }



    @GetMapping("/title2")
    public  String getBoardsByTitle2(@RequestParam("title") String title  , Model model ) {
        // 서비스에서 특정 사용자의 게시글 리스트 가져오기
        List<Board> list  =  boardService.getBoardsByTitle2(title);
        model.addAttribute("list", list);
        return "list";
    }


}
