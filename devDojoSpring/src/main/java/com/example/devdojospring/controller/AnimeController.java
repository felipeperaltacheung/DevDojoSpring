package com.example.devdojospring.controller;

import com.example.devdojospring.domain.Anime;
import com.example.devdojospring.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {


    private final DateUtil dateUtil;


    //@RequestMapping(method = RequestMethod.GET, path = "list") -> antigo
    @GetMapping(path = "list")
    public List<Anime> list (){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("BOKUBOKU"), new Anime("Berserk"));
    }

}
