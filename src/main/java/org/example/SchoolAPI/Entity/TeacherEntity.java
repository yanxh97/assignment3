package org.example.SchoolAPI.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private long id;

    @Column(name = "t_name")
    private String name;

    @OneToMany(mappedBy = "r_t_id")
    private List<RelationEntity> relationList;
}
