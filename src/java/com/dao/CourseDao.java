package com.dao;

import com.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getCoursebyTeacherID(int id);

}
