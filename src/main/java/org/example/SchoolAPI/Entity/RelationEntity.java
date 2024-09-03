package org.example.SchoolAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Teaching")
public class RelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "t_id")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private StudentEntity student;
}
