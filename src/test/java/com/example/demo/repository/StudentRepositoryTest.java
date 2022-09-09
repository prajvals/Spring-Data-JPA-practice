package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder().emailId("prajvaltheking@gmail.com").firstName("Prajval Singh").lastName("Rajput").guardianEmail("norealdetails@gmail.com").guardianMobile("8899787878").guardianName("hello").build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudents()
    {
        System.out.println(studentRepository.findAll());
    }

}