package org.example.SchoolAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long id;

    @Column(name = "s_name")
    private String name;
}
