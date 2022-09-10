package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CourseMaterial {

    @SequenceGenerator(
            name = "CourseMaterialSequence",
            sequenceName = "CourseMaterialSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CourseMaterialSequence"
    )
    @Id
    private Long courseMaterialId;
    private String url;

//    @OneToOne(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "course_id",
//    referencedColumnName = "courseId"
//    )
//    private Course courseObject;

}
