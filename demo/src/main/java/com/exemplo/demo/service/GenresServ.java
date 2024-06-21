package com.exemplo.demo.service;

import com.exemplo.demo.dto.GenreDTO;
import com.exemplo.demo.entity.Genres;
import com.exemplo.demo.repository.GenresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GenresServ {
    private final GenresRepository repository;

    public GenresServ(GenresRepository repository) {
        this.repository = repository;
    }

    public Genres createOrSave(GenreDTO dto) {
        // Valida se o gênero possui um nome válido.
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do Gênero não existe.");
        }

        // Busca o gênero informado, se não encontrar crie um novo.
        Genres genre = repository.findByName(dto.getName()).orElseGet(Genres::new);
        genre.setName(dto.getName());
        repository.save(genre);
        return genre;
    }
}
