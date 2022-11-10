package com.example.devdojospring.client;

import com.example.devdojospring.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);//mapendo automatico com jackson

        log.info(entity);

        Anime forObject = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(forObject);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class); //arrays de animes
        log.info(Arrays.toString(animes)); //arrays de animes



        //Super Type Tokens

        //@formatter:off
        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        //@formatter:on
        log.info(exchange.getBody());
    }
}
