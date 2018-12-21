package com.service;


import com.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCoursebyTeacherID(int id);
   // AllRoundScore getAllRoundScoreByCourseID(int courseId);
}
