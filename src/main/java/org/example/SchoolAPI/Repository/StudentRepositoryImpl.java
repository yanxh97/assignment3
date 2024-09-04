package org.example.SchoolAPI.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public StudentDTO createStudent(StudentDTO stuDTO) {
        StudentEntity stuEnt = new StudentEntity();
        EntityManager em = emf.createEntityManager();

        stuEnt.setName(stuDTO.getName());

        em.getTransaction().begin();
        em.persist(stuEnt);
        em.getTransaction().commit();
        em.close();
        stuDTO.setId(stuEnt.getId());
        return stuDTO;
    }

    @Override
    public List<StudentDTO> readAllStudent() {
        return List.of();
    }

    @Override
    public StudentDTO readStudentById(Long id) {
        StudentEntity stuEnt = null;
        StudentDTO stuDTO = new StudentDTO();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        stuEnt = em.find(StudentEntity.class, id);
        stuDTO.setId(stuEnt.getId());
        stuDTO.setName(stuEnt.getName());
        em.getTransaction().commit();
        em.close();

        return stuDTO;
    }

    @Override
    public boolean updateStudent(StudentDTO stuDTO) {
        StudentEntity stuEnt = new StudentEntity();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        stuEnt = em.find(StudentEntity.class, stuDTO.getId());
        stuEnt.setName(stuDTO.getName());
        em.persist(stuEnt);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public StudentDTO deleteStudentById(Long id) {
        StudentEntity stuEnt = null;
        StudentDTO stuDTO = new StudentDTO();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        stuEnt = em.find(StudentEntity.class, id);
        stuDTO.setId(stuEnt.getId());
        stuDTO.setName(stuEnt.getName());
        em.remove(stuEnt);
        em.getTransaction().commit();
        em.close();
        return stuDTO;
    }
}
