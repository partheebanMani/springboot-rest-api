package com.partheeban.component.controller;

import com.partheeban.component.model.Student;
import com.partheeban.component.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable("id") Integer id) throws Exception {
        return Optional.of(studentService.getStudent(id))
                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.noContent().build());
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @PostMapping("/")
    public ResponseEntity<Student> putStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

}
