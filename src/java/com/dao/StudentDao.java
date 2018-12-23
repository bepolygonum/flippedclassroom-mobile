package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KEKE
 */
@Repository
public interface StudentDao {
    /**
     * get Student By Account
     * @param account
     * @param password
     * @return
     */
    Student getStudentByAccount(String account, String password);

    /**
     * get Student By StudentID
     * @param studentIds
     * @return
     */
    List<Student> getStudentByStudentID(List<Integer> studentIds);

    /**
     * get TeamId By StudentId
     * @param id
     * @param courseid
     * @return
     */
    int getTeamIdByStudentId(int id,int courseid);

    /**
     * get Student By ID
     * @param studentId
     * @return
     */
    Student getStudentByID(int studentId);
}
