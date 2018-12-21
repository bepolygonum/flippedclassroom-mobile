package com.dao;

import java.util.List;

public interface ConflictCourseStrategyDao {
    List<Integer> getCourse2IDByCourseID(int courseId);
    List<Integer> getCourse1IDByCourseID(int courseId);
}
