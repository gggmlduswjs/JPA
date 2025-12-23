package com.example.helloJPA.optional;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        // Optional.ofNullable
        String value = null;
        //String value="string data";
        Optional<String> optionalValue = Optional.ofNullable(value);


        if( optionalValue.isPresent()){
            String v = optionalValue.get();
            System.out.println("꺼낸 값" +v);
        }

        // 값이 있으면 출력
        optionalValue.ifPresent(v -> System.out.println("값^^: " + v));

        // 값이 없으면 기본값 사용
        String result = optionalValue.orElse("기본값");
        System.out.println("결과: " + result);

        // 값이 없으면 예외 발생
        try {
            String mustValue = optionalValue.orElseThrow(() -> new IllegalArgumentException("값이 없습니다"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
