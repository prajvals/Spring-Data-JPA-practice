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
//        Student student = Student.b uilder().emailId("prajvaltheking@gmail.com").firstName("Prajval Singh").lastName("Rajput")

//        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder().email("pthisisa@gmail.com").name("hello").mobile("89898998989").build();
        Student student = Student.builder().guardian(guardian).emailId("thisisdfdfsdfsfwonderful@gmail.com").firstName("PrajvalSingh1").lastName("rajput").build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudents()
    {
        System.out.println(studentRepository.findAll());
    }

    @Test
    public void printStudentInfo()
    {
        System.out.println(studentRepository.getStudentByFirstName("PrajvalSingh1"));
//        System.out.println(studentRepository.findStudentByFirstName("PrajvalSingh"));
//        System.out.println(studentRepository.findStudentByLastName("rajput"));
//        System.out.println(studentRepository.findStudentByGuardianName("hello"));
//        System.out.println(studentRepository.findStudentByFirstNameAndLastName("PrajvalSingh","rajput"));
    }

}