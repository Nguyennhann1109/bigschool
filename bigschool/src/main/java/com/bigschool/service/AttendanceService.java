package com.bigschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigschool.entity.Attendance;
import com.bigschool.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance joinCourse(Integer courseId,String user){

        Attendance a = new Attendance();
        a.setCourseId(courseId);
        a.setAttendee(user);

        return attendanceRepository.save(a);
    }

    public void leaveCourse(Integer courseId,String user){

        Attendance a = attendanceRepository
                .findByCourseIdAndAttendee(courseId,user);

        if(a != null){
            attendanceRepository.delete(a);
        }
    }

    public List<Attendance> getCourseUser(String user){
        return attendanceRepository.findByAttendee(user);
    }
}