package com.example.devdojospring.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimeDTO implements Serializable {
    private Long id;
    private String name;
}
