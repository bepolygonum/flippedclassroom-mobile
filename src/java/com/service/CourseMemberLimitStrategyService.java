package com.service;

import com.entity.CourseMemberLimitStrategy;

public interface CourseMemberLimitStrategyService {
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId);
}
