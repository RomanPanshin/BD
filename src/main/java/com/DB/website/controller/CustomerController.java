package com.DB.website.controller;

import com.DB.website.entity.Customer;
import com.DB.website.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAllCustomers());
        return "customers"; // Thymeleaf template name
    }

    @DeleteMapping("/delete/{customerId}")
    @ResponseBody
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomerAndAccounts(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @PostMapping("/customers/edit")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Integer customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
