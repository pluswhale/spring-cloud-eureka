package com.pluswhale.customer.service;

import com.pluswhale.customer.CustomerRegistrationRequest;
import com.pluswhale.customer.FraudCheckResponse;
import com.pluswhale.customer.Repository.CustomerRepositoty;
import com.pluswhale.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepositoty customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if enal valid
        //todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        assert fraudCheckResponse != null;
        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        //store data in db
        //todo: send notification
    }
}
