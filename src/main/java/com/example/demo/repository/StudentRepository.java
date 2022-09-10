package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByLastName(String lastName);
    List<Student> findStudentByGuardianName(String guardianName);
    List<Student> findStudentByFirstNameAndLastName(String firstName,String lastName);

    @Query("select s from Student s where s.firstName =?1")
    List<Student> getStudentByFirstName(String firstName);

    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    List<Student> getStudentByFirstNameNativeQuery(String firstName);

    @Query(
            value = "select * from tbl_student s where s.email_address = :firstName",
            nativeQuery = true
    )
    List<Student> getStudentByFirstNameNativeQueryNamedParams(@Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2 ",
            nativeQuery = true
    )
    List<Student> updateStudentByFirstNameNativeQuery(String firstName,String emailAdress);

}
