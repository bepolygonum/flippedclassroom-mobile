package com.service.impl;

import com.dao.CourseDao;
import com.entity.Course;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public List<Course> getCoursebyAccount(String account) {
        return courseDao.getCoursebyAccount(account);
    }
}
