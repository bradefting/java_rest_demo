package com.demoRestApi.controllers;

import com.demoRestApi.models.Customer;
import com.demoRestApi.models.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chansehorton on 2/15/17.
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerDao.findAllByOrderByIdAsc();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {
        Customer customer = customerDao.findOne(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID" + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        customerDao.save(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        if (!customerDao.exists(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        customerDao.save(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        if (!customerDao.exists(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        Customer customer = customerDao.findOne(id);
        customerDao.delete(id);

        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
