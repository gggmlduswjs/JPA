package com.example.helloJPA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DramaRequest {

    Long id;
    String title;
    String actor;
    String imageUrl;


}
