package org.example.SchoolAPI.Service;

import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public StudentDTO createStudent(StudentDTO stuDTO);
    public List<StudentEntity> readAllStudent();
    public StudentDTO readStudentById(Long id);
    public boolean updateStudent(StudentDTO stuDTO);
    public StudentDTO deleteStudentById(Long id);
}
