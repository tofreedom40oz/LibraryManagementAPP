package com.siit.LibraryManagementApp.service;

import com.siit.LibraryManagementApp.entity.CustomerEntity;
import com.siit.LibraryManagementApp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomer(Integer customerId) {

        return customerRepository.findById(customerId).get();
    }

    public void deleteCustomer(CustomerEntity customerEntity) {

        customerRepository.deleteById(customerEntity.getId());
    }

}
