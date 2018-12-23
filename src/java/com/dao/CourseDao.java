package com.dao;

import com.entity.Course;
import org.springframework.stereotype.Repository;

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

}
