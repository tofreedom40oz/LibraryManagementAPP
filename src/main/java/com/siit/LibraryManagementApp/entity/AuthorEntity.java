package com.siit.LibraryManagementApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "author")

public class AuthorEntity {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            updatable = false
    )
    private int id;

    @Column(name= "author_name")
    private String author_name;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;

    public AuthorEntity(){ }
}
