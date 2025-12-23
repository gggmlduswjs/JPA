package com.acorn.BoardJPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    // userId로 사용자 조회
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable( name="userId") String userId) {
        User user = userService.getUserById(userId);
        System.out.println( "해당고객의 게시글");


        //객체그래프로 조회가능
        if (user.getList() != null ) {
            for (Board item : user.getList()) {
                System.out.println( "글 확인==>" +item.getTitle());  // 또는 item.getSomeProperty()와 같이 속성 값을 출력할 수 있습니다.
            }
        } else {
            System.out.println("리스트가 비어있거나 null입니다.");
        }



        if (user != null) {
            return user; // 사용자 정보 반환
        } else {
            return null; // 사용자 정보가 없을 경우 null 반환
        }


    }
}