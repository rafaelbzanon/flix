package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genres, Integer> {
    Optional<Genres> findByName(String name);
}
