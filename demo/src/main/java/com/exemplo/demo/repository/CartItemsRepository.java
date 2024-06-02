package com.exemplo.demo.repository;

import com.exemplo.demo.models.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

}
