package com.siit.LibraryManagementApp.controller;

import com.siit.LibraryManagementApp.entity.AuthorEntity;
import com.siit.LibraryManagementApp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")

public class AuthorController {

    private final AuthorService authorService;


    @PostMapping
    public AuthorEntity create(@Valid @RequestBody AuthorEntity authorEntity) {

        return authorService.createAuthor(authorEntity);
    }

    @GetMapping("/{authorId}")
    public AuthorEntity getAuthor(@PathVariable(name = "authorId") Integer authorId) {

        return authorService.getAuthor(authorId);
    }

    @DeleteMapping()
    public void deleteAuthor(@RequestBody AuthorEntity authorEntity) {

        authorService.deleteAuthor(authorEntity);
    }
    @GetMapping()
    public List<AuthorEntity> getAuthors() {

        return authorService.getAuthors();
    }

    @PutMapping
    public AuthorEntity update(@Valid @RequestBody AuthorEntity authorEntity) {

        return authorService.createAuthor(authorEntity);
    }
}
