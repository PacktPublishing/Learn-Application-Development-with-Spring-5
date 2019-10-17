package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Collection<Customer> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
