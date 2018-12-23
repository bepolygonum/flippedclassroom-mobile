package com.dao;

import com.entity.CourseMemberLimitStrategy;

/**
 * @author KEKE
 */
public interface CourseMemberLimitStrategyDao {
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId);

}
