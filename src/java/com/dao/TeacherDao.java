package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    Teacher getTeacherByAccount(String account, String password);
    List<Teacher> getTeacherByInfo(String info);
    List<Teacher> getTeachersByTeacherID(List<Integer> teacherIds);
    Teacher getTeacherByTeacherID(int teacherId);
}
