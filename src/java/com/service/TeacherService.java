package com.service;
import com.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacherbyAccount(String account, String password);
    List<Teacher> getTeacherbyInfo(String info);
}
