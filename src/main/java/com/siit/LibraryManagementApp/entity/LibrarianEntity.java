package com.siit.LibraryManagementApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name ="Librarian")
public class LibrarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @Column(name= "librarian_name"
    )
    private String librarian_name;

    @OneToOne
    private LibraryEntity library;

    public LibrarianEntity() {

    }
}
