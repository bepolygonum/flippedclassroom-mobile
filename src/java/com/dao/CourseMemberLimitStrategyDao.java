package com.dao;

import com.entity.CourseMemberLimitStrategy;

public interface CourseMemberLimitStrategyDao {
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId);

}
