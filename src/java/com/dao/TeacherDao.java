package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KEKE
 */
@Repository
public interface TeacherDao {
    /**
     * get Teacher By Account
     * @param account
     * @param password
     * @return
     */
    Teacher getTeacherByAccount(String account, String password);

    /**
     * get Teacher By Info
     * @param info
     * @return
     */
    List<Teacher> getTeacherByInfo(String info);

    /**
     * get Teachers By TeacherID
     * @param teacherIds
     * @return
     */
    List<Teacher> getTeachersByTeacherID(List<Integer> teacherIds);

    /**
     * get Teacher By TeacherID
     * @param teacherId
     * @return
     */
    Teacher getTeacherByTeacherID(int teacherId);

    /**
     * getAllTeachers
     * @return
     */
    List<Teacher> getAllTeachers();
}
