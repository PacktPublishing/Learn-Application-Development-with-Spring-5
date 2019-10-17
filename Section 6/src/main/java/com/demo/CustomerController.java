package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

    @Autowired
    private ReactiveCustomerRepository repository;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Mono<Customer> save(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Mono<Customer> update(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Mono<Customer> get(@PathVariable Long id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Flux<Customer> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public Mono<Customer> delete(@PathVariable Long id) {
        return repository.deleteById(id);
    }
}
