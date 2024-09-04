package org.example.SchoolAPI.Controller;

import jakarta.persistence.EntityManagerFactory;
import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class SchoolController {

    // Use constructor injection instead?
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO stuDTO){
        return new ResponseEntity<StudentDTO>(studentRepository.createStudent(stuDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> readAllStudent(){
        return new ResponseEntity<String>("Not implemented", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readStudentById(@PathVariable("id") Long id){

        return new ResponseEntity<StudentDTO>(studentRepository.readStudentById(id), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO stuDTO){
        // should we check if id exists?
        studentRepository.updateStudent(stuDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudentByID(@PathVariable("id") Long id){

        return new ResponseEntity<StudentDTO>(studentRepository.deleteStudentById(id), HttpStatus.OK);
    }
}
