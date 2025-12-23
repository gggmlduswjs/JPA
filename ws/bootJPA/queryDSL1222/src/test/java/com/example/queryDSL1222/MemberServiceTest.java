package com.example.queryDSL1222;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService service;


    @Test
    public  void test(){

        int size  =service.getMemberList().size();
        System.out.println(  size);
        assertTrue( size>1);

    }


    @Test
    public  void test2(){

        //김씨가 3명임
        int size =service.getMemberList2().size() ;
        assertTrue( size ==1);

    }



   @Test
    public  void test3(){

        //김씨가 3명임
        int size =service.getMemberList2().size() ;
        assertTrue( size ==1);

    }


  //@Test
   public  void test4(){

        //김씨가 3명임
        List<MemberGroupDTO> list=service.findMemberCountByGrade() ;
        System.out.println( list);


    }


    //@Test
    public  void test5(){

        //김씨가 3명임
        List<GradeCountDto> list=service.findMemberCountByGrade2() ;
        System.out.println( list);


    }


    @Test
    public  void test6(){

         List<Member> list  = service.getMemberList동적쿼리( "acorn01" ,"홍" , null);
         assertTrue( list.size() >= 1);
    }
}

/*
contains("홍") → '%홍%'

startsWith("홍") → '홍%'

endsWith("홍") → '%홍'
 */


// and m1_0.name like ? escape '!'
// %나 _ 같은 와일드카드 문자가 포함될 수 있어