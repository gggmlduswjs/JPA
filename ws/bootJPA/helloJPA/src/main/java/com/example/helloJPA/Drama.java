package com.example.helloJPA;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Drama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String title;


    private  String actors;


    private  String imageUrl;


    public Drama( DramaRequest dramaRequest) {
        this.title  = dramaRequest.title;
        this.actors = dramaRequest.actor;
        this.imageUrl = dramaRequest.imageUrl;
    }



}
