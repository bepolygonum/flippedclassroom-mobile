package com.service;
import com.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacherByAccount(String account, String password);
    List<Teacher> getTeacherByInfo(String info);

    List<Teacher> getTeachersByTeacherID(List<Integer> teacherIds);
}
