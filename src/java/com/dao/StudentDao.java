package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentDao {
    Student getStudentbyAccount(String account, String password);
}
