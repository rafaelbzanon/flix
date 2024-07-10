package com.exemplo.demo.repository;

import com.exemplo.demo.entity.Lists;
import com.exemplo.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListRepository extends JpaRepository<Lists, Integer> {
    Optional<Lists> findByUser(Users users);
    List<Lists> findAllByUser(Users users);

    Lists findByUserEmail(String userEmail);
}
