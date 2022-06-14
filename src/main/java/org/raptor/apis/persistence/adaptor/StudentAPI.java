package org.raptor.apis.persistence.adaptor;


import org.hibernate.annotations.GeneratorType;
import org.raptor.apis.persistence.domain.integration.model.Students;
import org.raptor.apis.persistence.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentAPI {

    /** --- members --- */
    @Autowired
    private StudentService studentService;


    public StudentAPI() {
        super();
    }

    @GetMapping(path = "all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allStudent() {
        ResponseEntity<?> response;
        final List<Students> students = studentService.getAllStudents();
        if ( students == null || students.isEmpty() ) {
                response = new ResponseEntity<List<Students>>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<List<Students>>(students , HttpStatus.FOUND);
        }

        return response;
    }

    @PostMapping(path = "add" , consumes = MediaType.APPLICATION_JSON_VALUE ,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Students> createStudent(@RequestBody final Students student) {
        ResponseEntity<Students> response;
        final Students _student = studentService.addStudent(student);
        if ( _student == null ) {
            response = new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Students>(_student , HttpStatus.FOUND);
        }

        return response;
    }

}
