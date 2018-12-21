package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student getStudentByAccount(String account, String password);
    List<Student> getStudentByStudentID(List<Integer> studentIds);
    int getTeamIdByStudentId(int id,int course_id);
}
