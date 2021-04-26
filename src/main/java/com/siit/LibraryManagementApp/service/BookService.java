package com.siit.LibraryManagementApp.service;

import com.siit.LibraryManagementApp.entity.BookEntity;
import com.siit.LibraryManagementApp.entity.CustomerEntity;
import com.siit.LibraryManagementApp.mapper.BookEntityToBookDtoMapper;
import com.siit.LibraryManagementApp.mapper.BooksDtoPostRequestToBookEntityMapper;
import com.siit.LibraryManagementApp.model.AddBooksFromFileRequestDTO;
import com.siit.LibraryManagementApp.model.AddBooksFromFileResponseDTO;
import com.siit.LibraryManagementApp.model.BuyBookDTO;
import com.siit.LibraryManagementApp.repository.AuthorRepository;
import com.siit.LibraryManagementApp.repository.BookRepository;
import com.siit.LibraryManagementApp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CustomerRepository customerRepository;

    private final BookEntityToBookDtoMapper bookEntityToBookDtoMapper;
    private final BooksDtoPostRequestToBookEntityMapper booksDtoPostRequestToBookEntityMapper;

    public BookEntity createBook(BookEntity book) throws Exception {
        authorRepository.findById(book.getAuthor().getId()).orElseThrow(() -> new Exception("No such author exists in the database."));

        return bookRepository.save(book);
    }

    public List<BookEntity> getBookss() {
        return bookRepository.findAll();
    }

    public BookEntity getBook(Integer bookId) {

        return bookRepository.findById(bookId).get();
    }

    public void deleteBook(BookEntity bookEntity) {

        bookRepository.deleteById(bookEntity.getId());
    }

    // buyBookDto contine id-ul customer-ului si al cartii
    public BuyBookDTO buyBook(BuyBookDTO buyBookDto) throws Exception {
        // folosind id-ul cartii din buyBookDto, o sa caut
        // cartea din DB care are id-ul respectiv si o salvez
        // in variabila book
        var book = bookRepository.findById(buyBookDto.getBook_id()).orElseThrow(() -> new Exception("No such book exists in database."));

        // verifica daca customer-ul cu id-ul furnizat in
        // buyBookDto exista in baza de date
        customerRepository.findById(buyBookDto.getCustomer_id()).orElseThrow(() -> new Exception("No such customer exists in the database."));

        // Pentru a marca cartea intoarsa din DB ca fiind cumparata,
        // trebuie sa ii asociem un customer (customer_id). Din acest
        // motiv vom creea un CustomerEntity
        var customer = new CustomerEntity();

        // folosind id-ul customer-ului din buyBookDto, voi seta
        // id-ul noului customer creat.
        customer.setId(buyBookDto.getCustomer_id());

        // Intr-un final adaugam (setam) customer-ul cartii intoarse
        // din DB la noul customer creat pentru a o marca ca vanduta
        book.setCustomer(customer);

        // Salvam modificarea produsa asupra cartii in DB.
        bookRepository.save(book);

        // response-ul intors pentru request
        return buyBookDto;
    }

    @Transactional(readOnly = false)
    public List<AddBooksFromFileResponseDTO> createBooks(List<AddBooksFromFileRequestDTO> booksDtoCreateRequestList) {

        return booksDtoCreateRequestList.stream()
                .map(bookReq -> booksDtoPostRequestToBookEntityMapper.mapDtoPostRequestToEntity(bookReq))
                .map(bookEntity -> bookRepository.save(bookEntity))
                .map(bookEntitySaved -> bookEntityToBookDtoMapper.mapEntityToDto(bookEntitySaved))
                .collect(toList());
    }


    @SneakyThrows
    @Transactional(readOnly = false)
    public List<AddBooksFromFileResponseDTO> createBooksFromFile(MultipartFile file) {

        if(file.isEmpty()){
            // throw exception
        }

        byte[] bytes = file.getBytes();
        String fileContent = new String(bytes);
        String[] rows = fileContent.split("\n");

        List<AddBooksFromFileRequestDTO> toCreate = new ArrayList<>();

        for(String row : rows){
            String[] rowSplitted = row.split(",");
            if (rowSplitted.length != 0) {
                AddBooksFromFileRequestDTO addBooksFromFileRequestDTO = AddBooksFromFileRequestDTO.builder()
                        .book_name(rowSplitted[0])
                        .nr_of_pages(Integer.valueOf(rowSplitted[1]))
                        .build();
                toCreate.add(addBooksFromFileRequestDTO);
            }
        }

        return createBooks(toCreate);
    }

}
