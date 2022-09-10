package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void save()
    {
        Course course = Course.builder().credits(6).title("DSA").build();

        CourseMaterial courseMaterial = CourseMaterial.builder().courseObject(course).url("WWW.prajval.com").build();

        courseMaterialRepository.save(courseMaterial);
    }


}