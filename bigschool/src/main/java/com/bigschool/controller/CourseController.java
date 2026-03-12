package com.bigschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bigschool.entity.Course;
import com.bigschool.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id){
        return courseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Course create(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id,@RequestBody Course course){

        Course c = courseRepository.findById(id).orElse(null);

        if(c != null){
            c.setPlace(course.getPlace());
            c.setDateTime(course.getDateTime());
            c.setLectureId(course.getLectureId());
            return courseRepository.save(c);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        courseRepository.deleteById(id);
    }

}