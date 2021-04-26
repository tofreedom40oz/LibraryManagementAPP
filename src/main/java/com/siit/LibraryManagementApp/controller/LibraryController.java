package com.siit.LibraryManagementApp.controller;

import com.siit.LibraryManagementApp.entity.LibraryEntity;
import com.siit.LibraryManagementApp.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;


    @PostMapping
    public LibraryEntity createLibrary(@Valid @RequestBody LibraryEntity libraryEntity) {

        return libraryService.createLibrary(libraryEntity);
    }

    @GetMapping("/{libraryId}")
    public LibraryEntity getLibrary(@PathVariable(name = "libraryId") Integer libraryId) {

        return libraryService.getLibrary(libraryId);
    }

    @DeleteMapping()
    public void deleteLibrary(@RequestBody LibraryEntity libraryEntity) {

        libraryService.deleteLibrary(libraryEntity);
    }
    @GetMapping()
    public List<LibraryEntity> getLibraries() {

        return libraryService.getLibraries();
    }

    @PutMapping
    public LibraryEntity updateLibrary(@Valid @RequestBody LibraryEntity libraryEntity) {

        return libraryService.createLibrary(libraryEntity);
    }
}
