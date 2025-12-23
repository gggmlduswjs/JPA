package com.example.helloJPA.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {
        
        
        //Consumer

        //함수형인터페이스

        // interface  Consumer<T> {
        //    void   accept(T);
        // }
        Consumer<String>  l1 = ( item )->System.out.println( item );        
        l1.accept("hello  lambda ^^");
        
        
        
        Consumer<String> l2  = new Consumer<String>() {
            @Override
            public void accept(String s) {
                   System.out.println( s);
            }
        };
        
        
        l2.accept("헬로우 람다");




        //
        List<String> movies = List.of(
                "쇼생크 탈출",
                "기생충",
                "스피드",
                "포레스트 검프",
                "보디가드",
                "타이타닉",
                "로마의 휴일",
                "메트릭스"
        );


        System.out.println("람다식으로 구현######################");
        movies.forEach( (item)  -> System.out.println(item) );


        System.out.println("익명클래스로 구현#####################");
        movies.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                 System.out.println(s);
            }
        });



        //
        System.out.println("이름있는 클래스로 구현#################");
        class A implements  Consumer<String>{
            @Override
            public void accept(String s) {
                  System.out.println( s);
            }
        }


        movies.forEach( new A( ));


    }
}



