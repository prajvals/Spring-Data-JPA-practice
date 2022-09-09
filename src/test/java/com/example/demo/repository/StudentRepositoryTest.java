package com.example.demo.repository;

import com.example.demo.entity.Guardian;
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
//        Student student = Student.builder().emailId("prajvaltheking@gmail.com").firstName("Prajval Singh").lastName("Rajput")

//        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder().email("p@gmail.com").name("daddy").mobile("8989898989").build();
        Student student = Student.builder().guardian(guardian).emailId("prajvalddddtheking@gmail.com").firstName("PrajvalSingh").lastName("rajput").build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudents()
    {
        System.out.println(studentRepository.findAll());
    }

}