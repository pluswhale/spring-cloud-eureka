package com.pluswhale.customer.Repository;

import com.pluswhale.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepositoty extends JpaRepository<Customer, Integer> {
}
