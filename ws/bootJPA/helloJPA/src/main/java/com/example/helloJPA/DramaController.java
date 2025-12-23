package com.example.helloJPA;

import jakarta.persistence.GeneratedValue;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class DramaController {

    private  final DramaService dramaService;

    public DramaController(DramaService dramaService ) {
        this.dramaService = dramaService;

    }


    @GetMapping("/register")
    public  String  register(){
        dramaService.register( new DramaRequest( null,"모범택시" ,"이제훈" , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkVEb6Uq2xJXx42HsRrhKPfHRciuCHsGBXQ&s"));
        return "redirect:/home";

    }


    @GetMapping("/modify")
    public  String  modify(){
        dramaService.modify( new DramaRequest(1l, "모범택시" ,"이제훈바보"  , null));
        return "redirect:/home";

    }




    // ② 전체 조회
    @GetMapping("/drama/list")
    public String  findAll(Model model) {
        List<DramaResponse>  list  = dramaService.findAll();
        model.addAttribute("list" ,list);
        return  "dramaList";
    }


    // ① 단건  조회
    @GetMapping("/drama/{id}")
    public String findOne(@PathVariable Long id, Model model) {
        DramaResponse dramaResponse = dramaService.findOne(id);
        model.addAttribute("drama", dramaResponse);
        return "dramaDetail";
    }

    // 단건 조회
    @GetMapping("/drama2/{id}")
    public String dramaDetail(@PathVariable Long id, Model model) {
        Optional<DramaResponse> optionalDrama = dramaService.findOne2(id);

        if (optionalDrama.isPresent()) {
            model.addAttribute("drama", optionalDrama.get());
        } else {
            model.addAttribute("drama", null); // 없으면 null 처리
            model.addAttribute("message", "드라마 정보가 없습니다.");
        }

        return "dramaDetail"; // Thymeleaf 뷰 이름
    }

    @GetMapping("/drama/page")
    public String dramaPage(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            Model model) {
        Page<DramaResponse> dramas = dramaService.findAllWithPaging(page, size);
        model.addAttribute("dramas", dramas.getContent()); // 실제 리스트
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dramas.getTotalPages());
        return "dramaList2";
    }



}
