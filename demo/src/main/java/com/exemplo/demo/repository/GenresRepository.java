package com.exemplo.demo.repository;

import com.exemplo.demo.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Integer> {
}
