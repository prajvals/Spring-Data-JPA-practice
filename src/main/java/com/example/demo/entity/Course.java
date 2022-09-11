package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //this is a lil tricky to understand but take it that, since here both the tables are many to many hence
    //for maintaining the mapping we will be creating a whole new table in itself alright
    //for that the joinCollumn will take which is the main collumn to take
    //and for the collumn of the other table it will be the inverse collumn alright yeah
    //and since the relation has been establised here only, we dont need to provide for it in the student table like
    //we did in the other ones as one to one, one to many and many to one.
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "StudentCourseMap",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> studentList;

    //this function is written to add students
    public void addStudents(Student student)
    {
        if(studentList==null)
            studentList = new ArrayList<Student>();
        studentList.add(student);
    }
}
/*
Some notes

ONE TO ONE

one to one relationship means, that one table has the foriegn key which is the primary key of the table we wanna connect with alright,
and whenever we insert value inside of the main table we may or may not enter the foriegn key,
this is one directional or unidirectional
which means, if you add courses, you may enter the course material or you may not but if you the optional is set to false then you have to enter always alright
besides this, if the fetch is lazy, it will only show the entry without its value
but if the fetch is eager, it will fetch us the complete object too
this happens when you are querrying the entity containing the foriegn key alright
but the entity which is connected is if that is ever asked for, then what happens is that only that entity comes and not the
entity with which its connected for that case we need the bidrectional mapping

this seems a bit murky to me, and I need to check

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

/*
Second note regarding one to many or many to one

see be it one to many or many to one, in both the cases, the foriegn key is added to the table containing many enteries alright
and why is that the case is because we have to only add a collumn there where as if we do it otherwise and maintain the database value in the
entity containing ones entity, there would be multiple rows of that alright yeah

so to evade that, and correspondingly where the relation is flowing, if its one to many then the entity have the one will have all
the code alright
and if its many to one relationship, it will be the one containing the relationship alright yeah.

and if its many to many, then i guess the values can be in any of the tables alright we can test this too, will test it
 */

/*
NOTE REGARDING THE CASCADE TYPE
1. See cascade means, that if we are applying some action on the parent entity, then perform the action on the associated entities too
there are types of it which determine which action of the parent entity will go do, but if we select all then all of the actions will go

NOTE REGARDING THE FETCH TYPE
1. The fetch type determines, when the associated entries too will be fetched from the document, if its eager, then their values
will be fetched the moment the call is made for the main one
2. but if the fetch type is lazy, then their values will be fetched only when required alright

NOTE REGARDING THE OPTIONAL
1. setting the optional to be false, we set the association to be mandatory which means you have to provide value for this one too alright

NOTE REGARDING BIDIRECTIONAL MAPPING
1. bidirectional mapping allows navigation in both ways, which means when you fetch the child database the parent will be accessible too
unlike the unidirectional one where such is not the case and it flows only from the parent to child
2. it also allows for cascading the operation from the child to the parent too alright yeah
 */

/*
Big discovery
the fetch type eager doesnt work with bidirectional mapping
 */
