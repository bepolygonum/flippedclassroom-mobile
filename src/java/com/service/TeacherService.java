package com.service;
import com.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacherbyAccount(int account, String password);
    List<Teacher> getAllTeacher();
    List<Teacher> getTeacherbyInfo(String info);
}
