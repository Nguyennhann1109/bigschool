package com.bigschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigschool.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

    List<Attendance> findByAttendee(String attendee);

    Attendance findByCourseIdAndAttendee(Integer courseId,String attendee);

}