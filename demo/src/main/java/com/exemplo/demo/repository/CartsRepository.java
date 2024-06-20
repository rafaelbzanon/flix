package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsRepository extends JpaRepository<Carts, Integer> {
}
