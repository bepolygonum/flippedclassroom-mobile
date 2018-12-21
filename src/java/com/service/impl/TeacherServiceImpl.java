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
    public Teacher getTeacherByAccount(String account, String password) {
        return teacherDao.getTeacherByAccount(account,password);
    }

    @Override
    public List<Teacher> getTeacherByInfo(String info) {
        return teacherDao.getTeacherByInfo(info);
    }

    @Override
    public List<Teacher> getTeachersByTeacherID(List<Integer> teacherIds)
    {
        return teacherDao.getTeachersByTeacherID(teacherIds);
    }

}
