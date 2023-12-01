package com.DB.website.service;

import com.DB.website.entity.Customer;
import com.DB.website.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

}

