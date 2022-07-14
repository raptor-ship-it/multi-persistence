package org.raptor.apis.persistence.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.raptor.apis.persistence.domain.integration.data.mysql.StudentRepository;
import org.raptor.apis.persistence.domain.integration.model.Students;
import org.raptor.apis.persistence.execute.Application;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.OutputFrame;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = Application.class)
@Testcontainers
@ActiveProfiles("mysql")
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceTest () {
        super();
    }
    @Container
    private static final MySQLContainer<?> databaseContainer =  new MySQLContainer<>("mysql:8.0.26")
            .withInitScript("init.sql")
            .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(
                StudentServiceTest.class)));;


    @DynamicPropertySource
    public static void properties( final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", databaseContainer::getJdbcUrl);
        registry.add("spring.datasource.username", databaseContainer::getUsername);
        registry.add("spring.datasource.password", databaseContainer::getPassword);

        return;
    }

    @Test
    public void addStudent() {
        System.out.println(databaseContainer.getLogs(OutputFrame.OutputType.STDOUT));

        Students students = new Students();
        students.setFirstName("Kuldip");
        students.setLastName("Bajwa");
        students.setDateOfBirth(new Date());

        Students _student = studentRepository.save(students);

        Assert.assertNotNull("student object not saved" , _student);

        return;
    }

}
