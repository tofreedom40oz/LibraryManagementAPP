package com.siit.LibraryManagementApp.controller;

import com.siit.LibraryManagementApp.entity.LibrarianEntity;
import com.siit.LibraryManagementApp.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/librarian")

public class LibrarianController {
    private final LibrarianService librarianService;


    @PostMapping
    public LibrarianEntity createLibrarian(@Valid @RequestBody LibrarianEntity librarianEntity) {

        return librarianService.createLibrarian(librarianEntity);
    }

    @GetMapping("/{librarianId}")
    public LibrarianEntity getLibrarian(@PathVariable(name = "librarianId") Integer librarianId) {

        return librarianService.getLibrarian(librarianId);
    }

    @DeleteMapping()
    public void deleteLibrarian(@RequestBody LibrarianEntity librarianEntity) {

        librarianService.deleteLibrarian(librarianEntity);
    }
    @GetMapping()
    public List<LibrarianEntity> getLibrarians() {

        return librarianService.getLibrarians();
    }

    @PutMapping
    public LibrarianEntity updateLibrarian(@Valid @RequestBody LibrarianEntity librarianEntity) {

        return librarianService.createLibrarian(librarianEntity);
    }
}
