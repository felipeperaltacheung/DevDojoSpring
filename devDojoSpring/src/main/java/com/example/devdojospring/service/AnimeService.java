package com.example.devdojospring.service;


import com.example.devdojospring.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService{

    private List<Anime> animes = List.of(new Anime(1L,"BOKUBOKU"), new Anime(2L, "Berserk"));

    //private final AnimeRepository animorepository;
    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

}
