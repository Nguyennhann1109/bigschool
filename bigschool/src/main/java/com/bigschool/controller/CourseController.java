package com.bigschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigschool.entity.Course;
import com.bigschool.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // CREATE COURSE
    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    // GET ALL COURSES
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    // COURSE I AM GOING
    @GetMapping("/going")
    public List<Course> courseIamGoing(@RequestParam String user){

        return courseService.courseIamGoing(user);
    }

    // LECTURE I AM FOLLOWING
    @GetMapping("/following")
    public List<Course> lectureIamFollowing(@RequestParam String user){

        return courseService.lectureIamFollowing(user);
    }

}