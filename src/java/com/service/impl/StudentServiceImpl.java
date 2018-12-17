package com.service.impl;
import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    public Student getStudentbyAccount(int account, String password) {
        return studentDao.getStudentbyAccount(account,password);
    }

    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }
}
