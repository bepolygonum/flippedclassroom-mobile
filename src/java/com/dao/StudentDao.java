package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student getStudentbyAccount(int account, String password);
    List<Student> getAllStudent();
}
