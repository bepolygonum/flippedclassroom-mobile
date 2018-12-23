package com.service;

import com.dao.CourseMemberLimitStrategyDao;
import com.entity.CourseMemberLimitStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KEKE
 */
@Service(value = "CourseMemberLimitStrategyService")
public class CourseMemberLimitStrategyServiceImpl {
    @Autowired
    CourseMemberLimitStrategyDao courseMemberLimitStrategyDao;

    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId) {
        return courseMemberLimitStrategyDao.getCourseMemberLimitStrategyByCourseID(courseId);
    }
}
