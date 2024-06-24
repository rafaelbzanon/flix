package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsRepository extends JpaRepository<Cart, Integer> {
}
