package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    Teacher getTeacherbyAccount(int account, String password);
    List<Teacher> getAllTeacher();
    List<Teacher> getTeacherbyInfo(String info);
}
