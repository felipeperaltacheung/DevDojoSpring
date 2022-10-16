package com.example.devdojospring.service;


import com.example.devdojospring.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService{

    //private final AnimeRepository animorepository;
    public List<Anime> listAll(){
        return List.of(new Anime(1L,"BOKUBOKU"), new Anime(2L, "Berserk"));
    }

}
