package com.trantor.jdbc.controller;

import com.trantor.jdbc.entity.Customer;
import com.trantor.jdbc.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class  CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/ctm")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepo.saveCustomer(customer);
    }


    @PutMapping("/ctm")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerRepo.updateCustomer(customer);
    }

    @GetMapping("/ctm/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerRepo.getById(id);
    }

    @GetMapping("/ctms")
    public List<Customer> getAllCustomers() {
        return customerRepo.allCustomer();
    }
}

