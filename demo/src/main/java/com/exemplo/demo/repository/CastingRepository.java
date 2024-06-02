package com.exemplo.demo.repository;

import com.exemplo.demo.models.Casting;
import com.exemplo.demo.models.ContentRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastingRepository extends JpaRepository<Casting, Integer> {
}
