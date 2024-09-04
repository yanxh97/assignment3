package org.example.SchoolAPI.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<StudentEntity> readAllStudent() {
        StudentEntity stuEnt = null;
        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        stuEnt = em.find(StudentEntity.class, 1);
//        System.out.println(stuEnt.getName());
//        System.out.println(stuEnt.getRelationList().get(0).getStudent().getName());
//        System.out.println(stuEnt.getRelationList().get(0).getTeacher().getName());
//        em.getTransaction().commit();
//        em.close();
        //Session session = sf.getCurrentSession();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> root = cq.from(StudentEntity.class);
        cq.select(root);
        cq.where(cb.gt(root.get("id"), 10));
        TypedQuery<StudentEntity> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public StudentDTO readStudentById(Long id) {
        StudentEntity stuEnt;
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
        StudentEntity stuEnt;
        StudentEntity stuEnt2 = new StudentEntity();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        stuEnt = em.find(StudentEntity.class, stuDTO.getId());
        if (stuEnt != null) {
            stuEnt.setName(stuDTO.getName());
            em.persist(stuEnt);
        }

        em.getTransaction().commit();
        em.close();
        return stuEnt!=null;
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
