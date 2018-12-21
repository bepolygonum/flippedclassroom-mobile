package com.service;
import com.entity.Student;

import java.util.List;

public interface StudentService {
    Student  getStudentByAccount(String account, String password);
    int  getTeamIdByStudentId(int id,int course_id);

    List<Student> getStudentByStudentID(List<Integer> studentIds);
}
