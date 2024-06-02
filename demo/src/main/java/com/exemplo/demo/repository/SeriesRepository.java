package com.exemplo.demo.repository;

import com.exemplo.demo.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}
