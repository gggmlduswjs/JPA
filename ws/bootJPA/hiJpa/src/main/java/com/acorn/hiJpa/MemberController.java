package com.acorn.hiJpa;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Transactional
@Controller
public class MemberController {


    @Autowired
    MemberService service;


    @GetMapping("/members/list")
    public String memberSelectAll(Model model){
        List<Member> list  = service.getMemberList();
        model.addAttribute("list", list);
        return "memberlist";
    }



    @GetMapping("/members/list2")
    public String memberSelectAll2(Model model){
        List<MemberResponse> list  = service.getMemberList2();
        model.addAttribute("list", list);
        return "memberlist2";
    }



    @GetMapping("/members/detail/{id}")
    public String selectOne( Model model,  @PathVariable(value="id" ) String id){
        Member member = service.getMember(id);
        model.addAttribute("member",member);
        return  "memberInfo";
    }


    
    @GetMapping("/members/register")
    public String insert( @ModelAttribute MemberRequest memberRequest ){
        return "memberForm";
    }



    @PostMapping("/members/register")
    public String insert2(Model model   , @ModelAttribute   MemberRequest m  , BindingResult bindingResult){
        //public String insert2(Model model   , @ModelAttribute @Validated MemberDTO m  , BindingResult bindingResult){

        if( m.getId().isBlank() || m.getId().isEmpty()){
            bindingResult.rejectValue("id", "required" ,"아이디 입력하세요" );
        }

        if(bindingResult.hasErrors() ) {
            return "memberForm";   //이렇게 사용
        }

        System.out.println(  m);
        Member member  = service.register(m);

        model.addAttribute("member", member);
        return "memberok";
    }





    @GetMapping("/members/modify")
    public String update(Model model ,  @RequestParam ( value="id" , defaultValue = "") String id ,
                                        @RequestParam ( value="newpw" , defaultValue = "") String newpw){

       // String id ="acorn1";
       // String newpw="0000000";

        service.modifyMember( id, newpw );
        return "updateok";
    }


    @GetMapping("/members/name")
    public String  getMembersName(@RequestParam(value="name" ,defaultValue = "") String name   ,
                              Model model  ) {
        List<Member> list=  service.getMembersByName(name );
        model.addAttribute("list",  list);
        return "memberlist";
    }



    @GetMapping("/members/name-jpql")
    public String  getMembersNamePw(@RequestParam(value="name" ,defaultValue = "") String name   ,
                                   Model model  ) {
        List<Member> list=  service.getMembersByNameJPQL(name );
        model.addAttribute("list",  list);
        return "memberlist";
    }


    @GetMapping("/members/deleteMember")
    public  String   deleteMember(  @RequestParam( value="id" , defaultValue = "") String id){
        service.deleteMemberById(id);
        return  "deleteOk";
    }



    //페이징 조회
    //페이지에서는 0페이지부터 있다
    @GetMapping("/members/page")
    public String  getMembers(
            @RequestParam(value="page" , defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size,
            Model model  ) {
        Page<Member> MemberPage=  service.findAll( page, size);
        model.addAttribute("membersPage",  MemberPage);
        return "memberpage2";
    }

    //페이징 조회
    @GetMapping("/members/name/page")
    public String  getMembersNsmr(@RequestParam(value="name" ,defaultValue = "") String name,
                                  @RequestParam(value="page" , defaultValue = "0") int page,
                                  @RequestParam(value="size", defaultValue = "10") int size,
                                  Model model  ) {
        Page<Member> MemberPage=  service.getMembersByName(name, page, size);
        model.addAttribute("membersPage",  MemberPage);
        return "memberpage";
    }


}
