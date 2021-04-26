package com.siit.LibraryManagementApp.mapper;

import com.siit.LibraryManagementApp.entity.BookEntity;
import com.siit.LibraryManagementApp.model.AddBooksFromFileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookEntityToBookDtoMapper {
    public AddBooksFromFileResponseDTO mapEntityToDto(BookEntity entity) {
        return AddBooksFromFileResponseDTO.builder()
                .id(entity.getId())
                .book_name(entity.getBook_name())
                .nr_of_pages(entity.getNr_of_pages())
                .build();

    }
}
