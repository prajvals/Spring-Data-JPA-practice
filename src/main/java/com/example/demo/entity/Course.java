package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
