package com.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KEKE
 */
@Repository
public interface ConflictCourseStrategyDao {

    /**
     * get course_2_id by course id
     * @param courseId 课程id
     * @return List of course_2_id
     */
    List<Integer> getCourse2IDByCourseID(int courseId);

    /**
     * get course_1_id by course id
     * @param courseId 课程id
     * @return List of course_1_id
     */
    List<Integer> getCourse1IDByCourseID(int courseId);
}
