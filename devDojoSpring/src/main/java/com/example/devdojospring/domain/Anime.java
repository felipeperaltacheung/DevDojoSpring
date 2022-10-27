package com.example.devdojospring.domain;


import lombok.*;


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
