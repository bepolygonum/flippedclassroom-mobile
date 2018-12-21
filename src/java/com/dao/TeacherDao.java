package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    Teacher getTeacherbyAccount(String account, String password);

    List<Teacher> getTeacherbyInfo(String info);
}
