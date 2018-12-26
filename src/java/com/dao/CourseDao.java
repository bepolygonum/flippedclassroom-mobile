package com.dao;

import com.entity.Course;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author KEKE
 */
@Repository
@SuppressWarnings("ALL")
public interface CourseDao {
    /**
     * get all courses by its teacher id
     * @param id teacher id
     * @return List of course
     */
    List<Course> getCourseByTeacherID(int id);

    /**
     * get all courses by list of course id
     * @param courseIds
     * @return
     */
    List<Course> getCoursesByCourseID(List<Integer> courseIds);

    /**
     * get all courses by student id
     * @param id
     * @return
     */
    List getCourseByStudentID(int id);

    /**
     * get all courses by course id
     * @param id
     * @return
     */
    Course getCourseByCourseID(int id);

    /**
     * get all courses by SeminarMainCourseID
     * @param id
     * @return
     */
    List<Course> getCourseBySeminarMainCourseID(int id);

    /**
     * get all courses by TeamMainCourseID
     * @param id
     * @return
     */
    List<Course> getCourseByTeamMainCourseID(int id);

    /**
     * getAllCourses
     * @return
     */
    List<Course> getAllCourses();

    /**
     * getCourseByCourseName
     * @param courseName
     * @return
     */
    Course getCourseByCourseName(String courseName);

    /**
     * createACourse
     * @param teacherId
     * @param courseName
     * @param introduction
     * @param presentationPercentage
     * @param questionPercentage
     * @param reportPercentage
     * @param teamStartTime
     * @param teamEndTime
     */
    void createACourse(int teacherId, String courseName, String introduction, int presentationPercentage,
                       int questionPercentage, int reportPercentage, Timestamp teamStartTime, Timestamp teamEndTime);
}
