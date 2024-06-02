package com.exemplo.demo.repository;

import com.exemplo.demo.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
}
