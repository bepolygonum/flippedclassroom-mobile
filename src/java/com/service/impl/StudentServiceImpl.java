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
    public Student getStudentByAccount(String account, String password) {
        return studentDao.getStudentByAccount(account,password);
    }

    @Override
    public int getTeamIdByStudentId(int id,int course_id) {
        return  studentDao.getTeamIdByStudentId(id,course_id);
    }

    @Override
    public List<Student> getStudentByStudentID(List<Integer> studentIds)
    {
        return studentDao.getStudentByStudentID(studentIds);
    }

}
