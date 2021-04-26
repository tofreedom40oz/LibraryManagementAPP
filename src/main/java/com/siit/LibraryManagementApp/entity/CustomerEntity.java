package com.siit.LibraryManagementApp.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name ="Customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @Column(name= "customer_name"
    )
    private String customer_name;

    @Column(name= "customer_email")
    private String customer_email;

    @OneToMany(mappedBy = "customer")
    private List<BookEntity> books;

    public CustomerEntity() {

    }
}
