package com.siit.LibraryManagementApp.repository;

import com.siit.LibraryManagementApp.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
