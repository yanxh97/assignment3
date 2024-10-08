package org.example.SchoolAPI.Controller;

import jakarta.persistence.EntityManagerFactory;
import org.example.SchoolAPI.DTO.StudentDTO;
import org.example.SchoolAPI.Entity.StudentEntity;
import org.example.SchoolAPI.Repository.StudentRepository;
import org.example.SchoolAPI.Service.StudentService;
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
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO stuDTO){
        return new ResponseEntity<StudentDTO>(studentService.createStudent(stuDTO),HttpStatus.CREATED);
    }

    @GetMapping("/query")
    public ResponseEntity<?> readAllStudent(){
        //actually read one specific student
        List<StudentEntity> stuEnt = studentService.readAllStudent();
        //.getRelationList().get(0).getTeacher().getName()
        return new ResponseEntity<List<StudentEntity>>(stuEnt, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readStudentById(@PathVariable("id") Long id){

        return new ResponseEntity<StudentDTO>(studentService.readStudentById(id), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO stuDTO){
        // should we check if id exists?
        if (studentService.updateStudent(stuDTO))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<StudentDTO>(stuDTO, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudentByID(@PathVariable("id") Long id){

        return new ResponseEntity<StudentDTO>(studentService.deleteStudentById(id), HttpStatus.OK);
    }
}
