package com.example.devdojospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Data
public class Anime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
