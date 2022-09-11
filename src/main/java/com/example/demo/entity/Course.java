package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "courseMaterial")
public class Course {

    @SequenceGenerator(
            sequenceName = "courseSequence",
            name = "courseSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "courseSequence"
    )
    @Id
    private Long courseId;
    private String title;
    private Integer credits;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "course_material_id",
            referencedColumnName = "courseMaterialId"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}
/*
Some notes

ONE TO ONE

one to one relationship means, that one table has the foriegn key which is the primary key of the table we wanna connect with alright,
and whenever we insert value inside of the main table we may or may not enter the foriegn key,
this is one directional or unidirectional
which means, if you add courses, you may enter the course material
but there is no place to enter the course in courseMaterial page and the foriegn key for the course entinty in course material does not exsist

so in such cases, what we do is we connect bidirectionally alright

ONE TO MANY

what is the case in here is that one entity is connected with many rows of another table
what is the difference here is that even when we define the one to many relation inside the entity which will be the one, entity of the one to many
entity schema, but the table changes with the foriegn key will go only in the table which contains many entity alright

and this is also unidirectional okay, when you save teacher, the course table will be updated
but when you update course, teacher table will not be updated

MANY TO ONE

here the foriegn key will be stored in the many one, where each entity will have the one's entry in it alright yeah
 */
