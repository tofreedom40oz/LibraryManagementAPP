package com.siit.LibraryManagementApp.controller;


import com.siit.LibraryManagementApp.entity.BookEntity;
import com.siit.LibraryManagementApp.model.AddBooksFromFileRequestDTO;
import com.siit.LibraryManagementApp.model.AddBooksFromFileResponseDTO;
import com.siit.LibraryManagementApp.model.BuyBookDTO;
import com.siit.LibraryManagementApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookEntity create(@Valid @RequestBody BookEntity book) throws Exception {
        return bookService.createBook(book);
    }

    @GetMapping("/{bookId}")
    public BookEntity getBook(@PathVariable(name = "bookId") Integer bookId) {

        return bookService.getBook(bookId);
    }

    @DeleteMapping()
    public void deleteBook(@RequestBody BookEntity bookEntity) {
        bookService.deleteBook(bookEntity);
    }
    @GetMapping()
    public List<BookEntity> getBooks() {
        return bookService.getBookss();
    }

    @PutMapping
    public BookEntity update(@Valid @RequestBody BookEntity book) throws Exception {
        return bookService.createBook(book);
    }

    @PostMapping("/buy")
    public BuyBookDTO buy(@Valid @RequestBody BuyBookDTO book) throws Exception {
//        {
//            "customer_id": 22,
//            "book_id":42
//        }
        bookService.buyBook(book);
        return book;
    }

    @ExceptionHandler(Exception.class)
    public void badRequest(HttpServletResponse response, Exception e) throws IOException {
        System.out.println(e.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
    @PostMapping("/bulk")
    public List<AddBooksFromFileResponseDTO> createBooks(@RequestBody @Valid List<AddBooksFromFileRequestDTO> booksDto){
        return bookService.createBooks(booksDto);
    }

    @PostMapping("/csv-upload")
    public List<AddBooksFromFileResponseDTO> createBooks(@RequestParam(name = "csv-file") MultipartFile file){
        return bookService.createBooksFromFile(file);
    }

}
