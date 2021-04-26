package com.siit.LibraryManagementApp.repository;

import com.siit.LibraryManagementApp.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
