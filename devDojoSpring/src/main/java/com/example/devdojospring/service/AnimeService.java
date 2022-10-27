package com.example.devdojospring.service;


import com.example.devdojospring.domain.Anime;
import com.example.devdojospring.exception.BadRequestException;
import com.example.devdojospring.repository.AnimeRepository;
import com.example.devdojospring.requests.AnimeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AnimeService{

    private final AnimeRepository animeRepository;
    private final ModelMapper modelMapper;

    public AnimeService(AnimeRepository animeRepository, ModelMapper modelMapper) {
        this.animeRepository = animeRepository;
        this.modelMapper = modelMapper;
    }

    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name){ return animeRepository.findByName(name);}

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    public Anime save(AnimeDTO animeDTO) {
        Anime anime = modelMapper.map(animeDTO, Anime.class);
        return animeRepository.save(anime);
    }


    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

}
