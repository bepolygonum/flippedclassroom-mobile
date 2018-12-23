package com.dao;

import com.entity.CourseMemberLimitStrategy;
import org.springframework.stereotype.Repository;

/**
 * @author KEKE
 */
@Repository
public interface CourseMemberLimitStrategyDao {
    /**
     * get CourseMemberLimitStrategy By CourseID
     * @param courseId
     * @return
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByCourseID(int courseId);

}
