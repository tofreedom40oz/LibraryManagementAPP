package com.siit.LibraryManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddBooksFromFileRequestDTO {

    private Integer id;
    private String book_name;
    private Integer nr_of_pages;


}
