package org.raptor.apis.persistence.service;


import org.raptor.apis.persistence.domain.integration.data.mysql.StudentRepository;
import org.raptor.apis.persistence.domain.integration.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    /**  --- members --- */
    @Autowired
    private StudentRepository studentRepository;


    public StudentService () {
        super();
    }


    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public Students addStudent( final Students student ) {
        return studentRepository.save( student );
    }


}
