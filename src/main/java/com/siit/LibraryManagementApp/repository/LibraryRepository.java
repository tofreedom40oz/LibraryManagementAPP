package com.siit.LibraryManagementApp.repository;

import com.siit.LibraryManagementApp.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity,Integer> {
}
