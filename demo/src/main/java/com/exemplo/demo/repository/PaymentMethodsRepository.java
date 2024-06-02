package com.exemplo.demo.repository;

import com.exemplo.demo.models.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
}
