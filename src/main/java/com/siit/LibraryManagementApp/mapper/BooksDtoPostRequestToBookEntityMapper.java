package com.siit.LibraryManagementApp.mapper;

import com.siit.LibraryManagementApp.entity.BookEntity;
import com.siit.LibraryManagementApp.model.AddBooksFromFileRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BooksDtoPostRequestToBookEntityMapper {
    public BookEntity mapDtoPostRequestToEntity(AddBooksFromFileRequestDTO dto) {
        return BookEntity.builder()
                .book_name(dto.getBook_name())
                .nr_of_pages(dto.getNr_of_pages())
                .build();
    }
}
