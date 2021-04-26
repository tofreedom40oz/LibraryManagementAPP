package com.siit.LibraryManagementApp.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name ="Books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(
            updatable = false
    )
    private int id;

    @Column(name= "book_name")
    private String book_name;


    @Column(name = "nr_of_pages")
    private int nr_of_pages;

    @ManyToOne
    private AuthorEntity author;

    @ManyToOne
    private CustomerEntity customer;

    @ManyToOne
    private LibraryEntity library;

    public BookEntity() {
    }


}
