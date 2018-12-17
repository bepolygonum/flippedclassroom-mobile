package com.controller;

import com.entity.Student;
import com.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminStudentController{
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/admin-student",method = RequestMethod.GET)
    public String adminstudent(Model model, @RequestParam String admin_account) {
        return "admin-student";
    }
}
