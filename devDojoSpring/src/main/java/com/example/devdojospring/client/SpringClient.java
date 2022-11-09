package com.example.devdojospring.client;

import com.example.devdojospring.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/1", Anime.class);//mapendo automatico com jackson
        log.info(entity);
    }
}
