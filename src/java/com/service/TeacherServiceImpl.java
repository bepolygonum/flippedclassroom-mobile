package com.service;
import com.dao.TeacherDao;
import com.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TeacherService")
public class TeacherServiceImpl {
    @Autowired
    TeacherDao teacherDao;
    public Teacher getTeacherByAccount(String account, String password) {
        return teacherDao.getTeacherByAccount(account,password);
    }

    public List<Teacher> getTeacherByInfo(String info) {
        return teacherDao.getTeacherByInfo(info);
    }

    public List<Teacher> getTeachersByTeacherID(List<Integer> teacherIds)
    {
        return teacherDao.getTeachersByTeacherID(teacherIds);
    }

    public  Teacher getTeacherByTeacherID(int teacherId){return teacherDao.getTeacherByTeacherID(teacherId);}

}
