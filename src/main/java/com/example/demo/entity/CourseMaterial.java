package com.example.demo.entity;


import lombok.*;

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

    @OneToOne(
     mappedBy = "courseMaterial"
    )
    private Course courseObject;

}
