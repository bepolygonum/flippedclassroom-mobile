package com.service.impl;

import com.dao.CourseMemberLimitStrategyDao;
import com.entity.CourseMemberLimitStrategy;
import com.service.CourseMemberLimitStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CourseMemberLimitStrategyService")
public class CourseMemberLimitStrategyServiceImpl implements CourseMemberLimitStrategyService {
    @Autowired
    CourseMemberLimitStrategyDao courseMemberLimitStrategyDao;
    @Override
    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId) {
        return courseMemberLimitStrategyDao.getCourseMemberLimitStrategyByCourseID(courseId);
    }
}
