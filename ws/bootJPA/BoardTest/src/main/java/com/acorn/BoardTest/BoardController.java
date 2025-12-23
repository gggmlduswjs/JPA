package com.acorn.BoardTest;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class BoardController {


    @Autowired
    BoardService service;


    //전체게시글 조회하기
    @GetMapping("/list")
    public  String getList( Model model){
        List<Board> list  = service.getSelectAll();
        model.addAttribute("list", list);
        return   "list";
    }



    @GetMapping("/write")
    public  String writeForm( Model model ){
        Board board = new Board();
        User user = new User();
        user.setId("user1");
        board.setUser(user);

        model.addAttribute("board", board);
        return  "write";
    }


    @PostMapping("/write")
    public  String write(Board board ){
       // User user = new User();
       // user.setId("user1");
       // board.setUser(user);

        System.out.println( board);

        board.setViewCnt(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());
        service.write( board);
        return  "write";
    }


    @GetMapping("/read")
    public String read( @RequestParam(name="bno") Long bno , Model model){
        Board board = service.read(bno);
        model.addAttribute("board" , board);
        System.out.println( "ddd" +board);
        return  "read";
    }



    //글 수정하기
    @GetMapping("/modify")
    public  String modify(  @RequestParam(name="bno") Long bno, Model model){
        Board board = service.read(bno);
        System.out.println("수정하고 싶은 글"  +board.getTitle());
        System.out.println("수정하고 싶은 글"  +board.getContent());
        model.addAttribute("board", board    );
        return  "write";
    }



    //글 삭제하기
    @PostMapping ("/remove")
    public  String remove( @RequestParam (name="bno") Long bno){
        service.remove(bno);
        return "redirect:/list";
    }


}
