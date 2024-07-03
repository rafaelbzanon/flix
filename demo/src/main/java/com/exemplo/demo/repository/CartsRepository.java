package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Cart;
import com.exemplo.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartsRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUser(Users users);
    List<Cart> findAllByUser(Users users);

    Cart findByUserEmail(String userEmail);
}