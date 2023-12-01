package com.DB.website.service;

import com.DB.website.entity.Account;
import com.DB.website.entity.Customer;
import com.DB.website.repository.AccountRepository;
import com.DB.website.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository; // Inject AccountRepository

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void deleteCustomerAndAccounts(Integer customerId) {
        accountRepository.findByCustomerCustomerId(customerId).forEach(accountRepository::delete);
        customerRepository.deleteById(customerId);
    }

    public void updateCustomer(Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(updatedCustomer.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        // Update fields
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setAge(updatedCustomer.getAge());
        existingCustomer.setProfession(updatedCustomer.getProfession());
        existingCustomer.setSex(updatedCustomer.getSex());
        customerRepository.save(existingCustomer);
    }
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}

