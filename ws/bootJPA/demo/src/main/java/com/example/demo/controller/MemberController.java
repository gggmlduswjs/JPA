package com.example.demo.controller;


import com.example.demo.domain.MemberResponse;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {



    @Autowired

    MemberService service;
    //
    @GetMapping("/list")
    public String  getMembers( Model model){


        List<MemberResponse> list  =service.getMemberList();
        System.out.println("dkfkdfjdf");
        System.out.println(list);

        model.addAttribute("list", list);
        return  "memberList";
    }


}
