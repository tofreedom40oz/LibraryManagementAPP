package com.siit.LibraryManagementApp.service;

import com.siit.LibraryManagementApp.entity.AuthorEntity;
import com.siit.LibraryManagementApp.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorEntity createAuthor(AuthorEntity authorEntity) {

        return authorRepository.save(authorEntity);
    }

    public List<AuthorEntity> getAuthors() {
        return authorRepository.findAll();
    }

    public AuthorEntity getAuthor(Integer authorId) {

        return authorRepository.findById(authorId).get();
    }

    public void deleteAuthor(AuthorEntity authorEntity) {

        authorRepository.deleteById(authorEntity.getId());
    }

}

