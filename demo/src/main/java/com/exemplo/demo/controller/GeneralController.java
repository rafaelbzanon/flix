package com.exemplo.demo.controller;

import com.exemplo.demo.entity.PaymentMethod;
import com.exemplo.demo.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/general")
@AllArgsConstructor
public class GeneralController {
    private final GeneralService service;

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentMethod>> getPaymentTypes() {
        return ResponseEntity.ok(service.getPaymentTypes());
    }

}
