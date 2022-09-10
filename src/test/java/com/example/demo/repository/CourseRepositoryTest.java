package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void save()
    {
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").build();

        Course course = Course.builder().title("hello").credits(11).courseMaterial(courseMaterial).build();

        courseRepository.save(course);
    }
}