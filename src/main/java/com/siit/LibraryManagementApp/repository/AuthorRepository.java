package com.siit.LibraryManagementApp.repository;

import com.siit.LibraryManagementApp.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Integer> {
}
