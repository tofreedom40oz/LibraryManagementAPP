package com.siit.LibraryManagementApp.controller;

import com.siit.LibraryManagementApp.entity.CustomerEntity;
import com.siit.LibraryManagementApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerEntity create(@Valid @RequestBody CustomerEntity customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{customerId}")
    public CustomerEntity getCustomer(@PathVariable(name = "customerId") Integer customerId) {

        return customerService.getCustomer(customerId);
    }

    @DeleteMapping()
    public void deleteCustomer(@RequestBody CustomerEntity customerEntity) {
        customerService.deleteCustomer(customerEntity);
    }

    @GetMapping()
    public List<CustomerEntity> getCustomers() {
        return customerService.getCustomers();
    }


    @PutMapping
    public CustomerEntity updateCustomer(@Valid @RequestBody CustomerEntity customerEntity)  {
        return customerService.createCustomer(customerEntity);
    }

}
