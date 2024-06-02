package com.exemplo.demo.repository;

import com.exemplo.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
