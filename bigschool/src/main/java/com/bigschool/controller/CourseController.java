package com.bigschool.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    List<Map<String,Object>> courses = new ArrayList<>();

    public CourseController(){

        Map<String,Object> c1 = new HashMap<>();
        c1.put("id",1);
        c1.put("place","Dong Nai");
        c1.put("lectureId","Nguyen Huy Cuong");
        c1.put("dateTime","2023-05-08T10:00");

        Map<String,Object> c2 = new HashMap<>();
        c2.put("id",2);
        c2.put("place","HCM");
        c2.put("lectureId","Tran Van A");
        c2.put("dateTime","2023-06-10T09:00");

        courses.add(c1);
        courses.add(c2);
    }

    @GetMapping
    public List<Map<String,Object>> getCourses(){
        return courses;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        courses.removeIf(c -> (int)c.get("id")==id);
    }

}