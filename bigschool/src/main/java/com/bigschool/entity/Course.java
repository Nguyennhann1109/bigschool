package com.bigschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String place;

    private String dateTime;

    private String lectureId;

}