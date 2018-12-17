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
    private AdminServiceImpl adminService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String user_account, @RequestParam String password, HttpServletResponse response) throws IOException {
        int account = Integer.parseInt(user_account);
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        Teacher teacher = teacherService.getTeacherbyAccount(account,password);
        Student student = studentService.getStudentbyAccount(account,password);
        List<Teacher> teacherList =teacherService.getAllTeacher();
        if(teacher!=null){
            return  "index_teacher";
        }
        else if(student!=null){
            return "index_student";
        }
        else {
            out.print("<script>alert('用户名或密码错误');history.go(-1);</script>");
        }
        return "admin-teacher";
    }
    @RequestMapping(value = "/search-teacher", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String admin_account) {
        List<Teacher> teacherList =teacherService.getTeacherbyInfo(info);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }
}
