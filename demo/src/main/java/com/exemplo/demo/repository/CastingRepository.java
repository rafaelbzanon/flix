package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Casting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastingRepository extends JpaRepository<Casting, Integer> {
}
