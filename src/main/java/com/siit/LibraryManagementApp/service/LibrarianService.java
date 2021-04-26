package com.siit.LibraryManagementApp.service;

import com.siit.LibraryManagementApp.entity.LibrarianEntity;
import com.siit.LibraryManagementApp.repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class LibrarianService {

    private final LibrarianRepository librarianRepository;


    public LibrarianEntity createLibrarian(LibrarianEntity librarianEntity) {

        return librarianRepository.save(librarianEntity);
    }

    public List<LibrarianEntity> getLibrarians() {
        return librarianRepository.findAll();
    }

    public LibrarianEntity getLibrarian(Integer librarianId) {

        return librarianRepository.findById(librarianId).get();
    }

    public void deleteLibrarian(LibrarianEntity librarianEntity) {

        librarianRepository.deleteById(librarianEntity.getId());
    }

}
