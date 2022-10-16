package com.example.devdojospring.repository;

import com.example.devdojospring.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
