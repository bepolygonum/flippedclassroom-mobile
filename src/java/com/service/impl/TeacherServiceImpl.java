package com.service.impl;
import com.dao.TeacherDao;
import com.entity.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;
    public Teacher getTeacherbyAccount(int account, String password) {
        return teacherDao.getTeacherbyAccount(account,password);
    }
    @Override
    public List<Teacher> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }

    @Override
    public List<Teacher> getTeacherbyInfo(String info) {
        return teacherDao.getTeacherbyInfo(info);
    }
}
