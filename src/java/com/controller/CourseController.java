package com.controller;

import com.entity.Course;
import com.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping(value = "/courseManage", method = RequestMethod.POST)
    public String findCourse(Model model, @RequestParam String account ) {
        List<Course> courseList = courseService.getCoursebyAccount(account);
        model.addAttribute(courseList);
        model.addAttribute("account",account);
        return "courseManage";
    }
}
