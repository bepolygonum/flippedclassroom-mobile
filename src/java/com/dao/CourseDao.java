package com.dao;

import com.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    List<Course> getCourseByTeacherID(int id);
    List<Course> getCoursesByCourseID(List<Integer> courseIds);
    //student
    List getCourseByStudentID(int id);
    Course getCourseByCourseID(int id);
}
