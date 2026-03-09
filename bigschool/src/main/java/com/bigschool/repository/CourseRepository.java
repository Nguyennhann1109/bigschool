package com.bigschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigschool.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

    List<Course> findByLectureId(String lectureId);

}