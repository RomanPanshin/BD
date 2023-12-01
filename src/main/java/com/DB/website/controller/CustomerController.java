package com.DB.website.controller;

import com.DB.website.entity.Customer;
import com.DB.website.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "customers"; // This is the name of the Thymeleaf template
    }
}
