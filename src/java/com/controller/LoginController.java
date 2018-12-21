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

@Controller
public class LoginController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String account, @RequestParam String password, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        Teacher teacher = teacherService.getTeacherByAccount(account,password);
        Student student = studentService.getStudentByAccount(account,password);
        if(teacher!=null){
            model.addAttribute(teacher);
            return "teacher/home";
        }
        if(student!=null){
            model.addAttribute(student);
            return "student/home";
        }
        else {
            out.print("<script>alert('用户名或密码错误');history.go(-1);</script>");
        }
        return "";
    }

}
