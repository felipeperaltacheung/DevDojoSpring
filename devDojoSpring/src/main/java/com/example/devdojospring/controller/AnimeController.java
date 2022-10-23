package com.example.devdojospring.controller;

import com.example.devdojospring.domain.Anime;
import com.example.devdojospring.requests.AnimeDTO;
import com.example.devdojospring.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    //private final DateUtil dateUtil;


    @GetMapping
    public ResponseEntity<List<Anime>> list (){
        //log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        //return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK); ou
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }


    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Anime> create(@RequestBody AnimeDTO animeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.save(animeDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
