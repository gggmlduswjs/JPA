package com.example.helloJPA;

import lombok.Data;

@Data
public class DramaResponse {

    private Long id;
    private String title;
    private String actors;
    private  String imageUrl;

    public DramaResponse(Drama drama) {
        this.id = drama.getCode();
        this.title = drama.getTitle();
        this.actors = drama.getActors();
        this.imageUrl   = drama.getImageUrl();
    }

    // getter
}
