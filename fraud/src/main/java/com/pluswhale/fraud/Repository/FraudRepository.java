package com.pluswhale.fraud.Repository;

import com.pluswhale.fraud.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Integer> {
}
