package org.example.SchoolAPI.Service;

import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Entity.StudentEntity;
import org.example.SchoolAPI.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public StudentDTO createStudent(StudentDTO stuDTO) {
        return studentRepository.createStudent(stuDTO);
    }

    @Override
    @Transactional
    public List<StudentEntity> readAllStudent() {
        return studentRepository.readAllStudent();
    }

    @Override
    @Transactional
    public StudentDTO readStudentById(Long id) {
        return studentRepository.readStudentById(id);
    }

    @Override
    @Transactional
    public boolean updateStudent(StudentDTO stuDTO) {
        return studentRepository.updateStudent(stuDTO);
    }

    @Override
    @Transactional
    public StudentDTO deleteStudentById(Long id) {
        return studentRepository.deleteStudentById(id);
    }
}
