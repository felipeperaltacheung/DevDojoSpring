package com.example.devdojospring.controller;

import com.example.devdojospring.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {

    //@RequestMapping(method = RequestMethod.GET, path = "list") -> antigo
    @GetMapping(path = "list")
    public List<Anime> list (){
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }

}
