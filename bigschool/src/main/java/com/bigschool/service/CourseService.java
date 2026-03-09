package com.bigschool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigschool.entity.Attendance;
import com.bigschool.entity.Course;
import com.bigschool.entity.Following;
import com.bigschool.repository.AttendanceRepository;
import com.bigschool.repository.CourseRepository;
import com.bigschool.repository.FollowingRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private FollowingRepository followingRepository;

    // CREATE COURSE
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    // GET ALL COURSES
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // COURSE I AM GOING
    public List<Course> courseIamGoing(String user){

        List<Attendance> attendances =
                attendanceRepository.findByAttendee(user);

        List<Course> result = new ArrayList<>();

        for(Attendance a : attendances){

            Course c =
                courseRepository.findById(a.getCourseId()).orElse(null);

            if(c != null){
                result.add(c);
            }
        }

        return result;
    }

    // LECTURE I AM FOLLOWING
    public List<Course> lectureIamFollowing(String user){

        List<Following> list =
                followingRepository.findByFollower(user);

        List<Course> result = new ArrayList<>();

        for(Following f : list){

            List<Course> courses =
                    courseRepository.findByLectureId(f.getFollowee());

            result.addAll(courses);
        }

        return result;
    }

}