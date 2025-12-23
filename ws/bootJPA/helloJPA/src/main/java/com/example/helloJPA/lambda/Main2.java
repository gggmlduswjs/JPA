package com.example.helloJPA.lambda;

import java.util.function.Supplier;

public class Main2 {

    public static void main(String[] args) {


        Supplier<Integer> s1 = ()-> 5;
        Supplier<Integer> s2  =  () ->  (int) ( Math.random()*10) +1 ;


        int result1  = s1.get();
        int result2  = s2.get();

        System.out.println(  result1);
        System.out.println(  result2);





        //
        Supplier<Exception>  s3 =  ()-> new RuntimeException("오류발생");

        Exception e = s3.get();
        System.out.println( e);



        //

        Supplier<Exception> s4 = new Supplier<Exception>() {
            @Override
            public Exception get() {
                return new RuntimeException("오류발생");
            }
        };


        Exception   e2 =s4.get();


        System.out.println( e);
        System.out.println( e2);




    }
}
