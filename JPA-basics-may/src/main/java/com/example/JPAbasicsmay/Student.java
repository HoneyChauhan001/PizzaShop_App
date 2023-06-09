package com.example.JPAbasicsmay;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private int age;
    @Column(name = "full_name")
    private String name;
    private int marks;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) //creating parent -> child connnection, Cascade to apply all crud operations on parent bew applied on child also
    LibraryCard libraryCard;

}
