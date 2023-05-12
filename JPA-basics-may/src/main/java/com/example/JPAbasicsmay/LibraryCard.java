package com.example.JPAbasicsmay;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate P.K
    private int id;
    @Enumerated(EnumType.STRING) //convert Enum to string in SQL table
    private Department department;
    @CreationTimestamp //to automatically assign creation date
    private Date issuedate;
    @UpdateTimestamp
    private Date lastTransactionDate;
    @OneToOne //relationship from this entity to student entity
    @JoinColumn //adding foreign key column in child class SQL schema
    Student student;


}
