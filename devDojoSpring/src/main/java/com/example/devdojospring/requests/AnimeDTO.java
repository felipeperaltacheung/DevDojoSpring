package com.example.devdojospring.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AnimeDTO implements Serializable {
    private Long id;

    @NotEmpty(message = "the anime cnnot be empty")
    private String name;
}
