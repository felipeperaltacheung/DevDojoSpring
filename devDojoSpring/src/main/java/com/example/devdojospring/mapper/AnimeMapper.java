package com.example.devdojospring.mapper;

import com.example.devdojospring.domain.Anime;
import com.example.devdojospring.requests.AnimePostRequestBody;
import com.example.devdojospring.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class); //para chamar os metodos
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePostRequestBody);
}
