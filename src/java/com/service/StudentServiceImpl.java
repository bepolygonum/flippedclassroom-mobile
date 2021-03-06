package com.service;
import com.dao.StudentDao;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KEKE
 */
@Service(value = "StudentService")
public class StudentServiceImpl {
    @Autowired
    StudentDao studentDao;

    public Student getStudentByID(int studentId) {
        return studentDao.getStudentByID(studentId);
    }

    public Student getStudentByAccount(String account, String password) {
        return studentDao.getStudentByAccount(account,password);
    }

    public void setEmailByID(int studentId, String newmail) {studentDao.setEmailByID(studentId, newmail);}

    public List<Student> getStudentByStudentID(List<Integer> studentIds)
    {
        return studentDao.getStudentByStudentID(studentIds);
    }
}
