package com.siit.LibraryManagementApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Library")

public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String library_name;

    @Column(name = "library_address")
    private String library_address;

    @OneToMany(mappedBy = "library")
    private List<BookEntity> books;

    @OneToOne
    private LibrarianEntity librarian;

    public LibraryEntity() {
    }

}
