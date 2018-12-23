package com.dao;

import java.util.List;

/**
 * @author KEKE
 */
public interface ConflictCourseStrategyDao {
    List<Integer> getCourse2IDByCourseID(int courseId);
    List<Integer> getCourse1IDByCourseID(int courseId);
}
