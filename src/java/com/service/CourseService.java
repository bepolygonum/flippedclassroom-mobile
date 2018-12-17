package com.service;

import com.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCoursebyAccount(String account);
}
