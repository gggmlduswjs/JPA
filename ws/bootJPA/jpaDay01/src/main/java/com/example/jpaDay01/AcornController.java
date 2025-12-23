package com.example.jpaDay01;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AcornController {

    private final AcornService service;


    // 생성자 주입
    // @Autowired
    public AcornController(AcornService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Acorn> getAcorns() {
        return service.getAcornList();
    }

    // 한 개 조회
    @ResponseBody
    @GetMapping("/acorn")
    public  Acorn getAcornOne(@RequestParam (name = "id") String id) {

        return  service.getAcornOne(id);
    }
    
    // 등록하기

    //등록하기
    @GetMapping("/register")
    public   String  register(){
        service.register();
        return  "redirect:/home";
    }

    // 수정하기
    @GetMapping("/modify")
    public String modify(){
        service.modify();
        return "redirect:/home";
    }

    // 삭제하기

    // delete?id=honghong
    @GetMapping("/delete")
    public String deleteOne(@RequestParam (name = "id") String id ) {
        service.deleteAcorn(id);
        return "redirect:/home";
    }

    // 이름으로 조회하기
    @GetMapping("/acornName")
    @ResponseBody
    public  Acorn getAcornName(@RequestParam(name = "name") String name) {
        return service.getAcornName(name);
    }


    //
    @GetMapping("/acornNameList")
    @ResponseBody
    public  List<Acorn> getAcornNameList(@RequestParam(name = "lastName") String lastName) {
        return  service.getAcornListName(lastName);
    }

    @ResponseBody
    @GetMapping("/acornNameJPQL")
    public Acorn getAcornNameJPQL(@RequestParam(name = "name") String name) {

        return service.getAcornNameJPQL(name);
    }


    // 페이징처리


    @GetMapping("/listpage")
    public  String acornListPage(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "page",defaultValue = "3") int size ,
            Model model) {

        Page<Acorn> listPage=service.getAcornListPage(page, size);
        System.out.println(listPage);
        System.out.println(listPage.getContent());
        System.out.println(listPage.getTotalPages()); // 전체 페이지 수

        List<Acorn> list=listPage.getContent();
        int totalPages =listPage.getTotalPages();

        model.addAttribute("list", list); // 페이징리스트
        model.addAttribute("totalPages",totalPages); // 전체 페이지 수
        model.addAttribute("currentPages",totalPages); // 현재페이지 => 0부터 시작한다
        return "list";
    }



}
