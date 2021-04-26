package com.siit.LibraryManagementApp.service;

import com.siit.LibraryManagementApp.entity.LibraryEntity;
import com.siit.LibraryManagementApp.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class LibraryService {
    private final LibraryRepository libraryRepository;


    public LibraryEntity createLibrary(LibraryEntity libraryEntity) {

        return libraryRepository.save(libraryEntity);
    }

    public List<LibraryEntity> getLibraries() {
        return libraryRepository.findAll();
    }

    public LibraryEntity getLibrary(Integer libraryId) {

        return libraryRepository.findById(libraryId).get();
    }

    public void deleteLibrary(LibraryEntity libraryEntity) {

        libraryRepository.deleteById(libraryEntity.getId());
    }
}
