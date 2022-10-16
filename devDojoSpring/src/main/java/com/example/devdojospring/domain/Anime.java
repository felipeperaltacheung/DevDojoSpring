package com.example.devdojospring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Anime {

    private Long id;

    //@JsonProperty("name") jogar o atributo para name
    //private String nameCharacter;

    private String name;
}
