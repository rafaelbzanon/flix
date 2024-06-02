package com.exemplo.demo.repository;

import com.exemplo.demo.models.Years;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearsRepository extends JpaRepository<Years, Integer> {
}
