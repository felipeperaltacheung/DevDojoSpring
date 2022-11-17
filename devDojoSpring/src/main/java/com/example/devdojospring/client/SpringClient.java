package com.example.devdojospring.client;

import com.example.devdojospring.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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

//        Anime kingdom = Anime.builder().name("kingdom").build();
//        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", kingdom, Anime.class);
//        log.info("saved anime {}", kingdomSaved);

        Anime samuraiChamplo = Anime.builder().name("Samurai Champlo").build();
        ResponseEntity<Anime> samuraiChamploSaved = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.POST,
                new HttpEntity<>(samuraiChamplo, createJsonHeader() ),
                Anime.class);

        log.info("saved anime {}", samuraiChamploSaved);

        /////////update
        Anime animeToBeUpdated = samuraiChamploSaved.getBody();
        animeToBeUpdated.setName("Samurai x2");

        ResponseEntity<Void> samuraiChamploUpdated = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated, createJsonHeader()),
                Void.class);

        log.info(samuraiChamploUpdated);

        //////////delete
        Anime animeToBeDelete = samuraiChamploSaved.getBody();
        animeToBeUpdated.setName("Samurai x2");

        ResponseEntity<Void> samuraiChamploDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                animeToBeUpdated.getId());

        log.info(samuraiChamploDeleted);


    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
