package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Teacher teacher = Teacher.builder().firstName("prajvalsingh").LastName("rajput").build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("WWW.google.com").build();
        CourseMaterial courseMaterial1 = CourseMaterial.builder().url("WWW.yahoo.com").build();

        Course course = Course.builder().credits(6).title("DBA").courseMaterial(courseMaterial).teacher(teacher).build();
        Course course1 = Course.builder().credits(6).title("Discerete mathematical structures").courseMaterial(courseMaterial1).build();

        List<Course> list = new ArrayList<Course>();
        list.add(course);
        list.add(course1);



//        Teacher teacher = Teacher.builder().firstName("jai ho").LastName("Om").course(list).build();

//        teacherRepository.save(teacher);
    }
}