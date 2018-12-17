package com.controller;

import com.entity.Student;
import com.entity.Teacher;
import com.service.impl.StudentServiceImpl;
import com.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class AdminTeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/search-teacher", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String admin_account) {
        List<Teacher> teacherList =teacherService.getTeacherbyInfo(info);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }
}
