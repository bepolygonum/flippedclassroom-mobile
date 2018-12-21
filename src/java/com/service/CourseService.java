package com.service;


import com.entity.Course;
import com.entity.CourseMemberLimitStrategy;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByTeacherID(int id);
    List<Course> getConflictCourseByCourseID(int course_id);

    //student
    List<Course> getCourseByStudentID(int id);
    Course getCourseByCourseID(int course_id);

    CourseMemberLimitStrategy getCourseMemberLimitByCourseID(int course_id);
}
