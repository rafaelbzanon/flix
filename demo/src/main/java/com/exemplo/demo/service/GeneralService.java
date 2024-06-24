package com.exemplo.demo.service;

import com.exemplo.demo.entity.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {

    public List<PaymentMethod> getPaymentTypes() {
        return List.of(PaymentMethod.values());
    }

}
