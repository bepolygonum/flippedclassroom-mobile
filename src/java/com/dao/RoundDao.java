package com.dao;

import com.entity.Round;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
@Repository
public interface RoundDao {
    /**
     * get Round By CourseID
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseID(int courseId);

}
