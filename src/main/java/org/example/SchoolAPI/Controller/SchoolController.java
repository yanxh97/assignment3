package org.example.SchoolAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class SchoolController {
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudentByID(@PathVariable("id") long id){
        return new ResponseEntity<String>("Student " + id + " deleted", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> postNewStudent(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<String>("All students", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> updateStudentByID(@PathVariable("id") long id){
        return new ResponseEntity<String>("Student " + id + " updated", HttpStatus.OK);
    }
}
