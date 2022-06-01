package com.pluswhale.fraud.Service;

import com.pluswhale.fraud.Repository.FraudRepository;
import com.pluswhale.fraud.model.Fraud;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    @Autowired
    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(
                Fraud.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAtTime(LocalDateTime.now())
                    .build()
        );
        return false;
    }
}
