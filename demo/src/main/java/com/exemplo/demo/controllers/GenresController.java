package com.exemplo.demo.controllers;

import com.exemplo.demo.models.Genres;
import com.exemplo.demo.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/genres")
public class GenresController {

    @Autowired
    private GenresRepository genresRepository;

    @GetMapping
    public ResponseEntity<List<Genres>> findAll() {
        return ResponseEntity.ok(genresRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Genres> save(@RequestBody Genres genres) {
        return ResponseEntity.ok(genresRepository.save(genres));
    }

    @PutMapping
    public ResponseEntity<Genres> update(@RequestBody Genres genres) {
        return ResponseEntity.ok(genresRepository.save(genres));
    }

    @DeleteMapping
    public ResponseEntity<Genres> delete(@RequestBody Genres genres) {
        genresRepository.delete(genres);
        return ResponseEntity.ok(genres);
    }

}
