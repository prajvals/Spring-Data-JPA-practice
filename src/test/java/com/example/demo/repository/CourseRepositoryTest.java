package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void save()
    {
        Teacher teacher = Teacher.builder().firstName("prajvalsingh").LastName("rajput").build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("WWW.google.com").build();
        CourseMaterial courseMaterial1 = CourseMaterial.builder().url("WWW.yahoo.com").build();

        Course course = Course.builder().credits(6).title("DBA").courseMaterial(courseMaterial).teacher(teacher).build();
        Course course1 = Course.builder().credits(6).title("Discerete mathematical structures").courseMaterial(courseMaterial1).build();

        List<Course> list = new ArrayList<Course>();
        list.add(course);
        list.add(course1);

        courseRepository.save(course);

//        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").build();
//        Course course = Course.builder().title("hello").credits(11).courseMaterial(courseMaterial).build();
//        courseRepository.save(course);
    }
    @Test
    public void fetchDetails()
    {
        System.out.println(courseRepository.findAll());
    }

    @Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeEntries = PageRequest.of(0,3);
        Pageable secondPageWithTwoEntries = PageRequest.of(1, 2);
        System.out.println(courseRepository.findAll(firstPageWithThreeEntries).getContent());
        System.out.println(courseRepository.findAll(firstPageWithThreeEntries).getTotalPages());
        System.out.println(courseRepository.findAll(firstPageWithThreeEntries).getTotalElements());
    }

    //using pagination with a custom method
    @Test
    public void findAllPaginationWithSorting()
    {
        Pageable customMethodPagination = PageRequest.of(0,3);
        System.out.println(courseRepository.findByTitleContaining("D",customMethodPagination).getContent());
    }
    //see we use pageable to implement pagination, in the sense that it restricts the number of or the number of entries that do come up alright yeah




}