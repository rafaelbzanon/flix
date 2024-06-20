package com.exemplo.demo.service;

import com.exemplo.demo.dto.GenreDTO;
import com.exemplo.demo.entity.Genres;
import com.exemplo.demo.repository.GenresRepository;
import org.springframework.stereotype.Service;

@Service
public class GenresServ {
    private final GenresRepository repository;

    public GenresServ(GenresRepository repository) {
        this.repository = repository;
    }

    public Genres createOrSave(GenreDTO dto) {
        Genres genre = (dto.getName() == null) ? new Genres() :
                repository.findByName(dto.getName()).orElseGet(Genres::new);
        repository.save(genre);
        return genre;
    }
}
