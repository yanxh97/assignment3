package org.example.SchoolAPI.Repository;

import org.example.SchoolAPI.DTO.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    public StudentDTO createStudent(StudentDTO stuDTO);
    public List<StudentDTO> readAllStudent();
    public StudentDTO readStudentById(Long id);
    public boolean updateStudent(StudentDTO stuDTO);
    public StudentDTO deleteStudentById(Long id);
}
