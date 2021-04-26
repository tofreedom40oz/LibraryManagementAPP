package com.siit.LibraryManagementApp.repository;

import com.siit.LibraryManagementApp.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity,Integer> {
}
