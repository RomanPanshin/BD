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
@RequestMapping("/customers") // Base path for all customer-related actions
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAllCustomers());
        return "customers";
    }

    @DeleteMapping("/delete/{customerId}")
    @ResponseBody
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomerAndAccounts(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Customer added successfully");
    }

    // Other methods...
}
