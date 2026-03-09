package com.bigschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigschool.entity.Attendance;
import com.bigschool.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/join")
    public Attendance joinCourse(@RequestParam Integer courseId,
                                 @RequestParam String user){

        return attendanceService.joinCourse(courseId,user);
    }

    @DeleteMapping("/leave")
    public void leaveCourse(@RequestParam Integer courseId,
                            @RequestParam String user){

        attendanceService.leaveCourse(courseId,user);
    }

    @GetMapping("/mycourse")
    public List<Attendance> myCourse(@RequestParam String user){

        return attendanceService.getCourseUser(user);
    }
}