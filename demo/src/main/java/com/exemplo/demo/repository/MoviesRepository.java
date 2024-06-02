package com.exemplo.demo.repository;

import com.exemplo.demo.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
