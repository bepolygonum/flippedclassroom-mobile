package com.dao;

import com.entity.Seminar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface SeminarDao {
    List<Seminar> getSeminarByRoundID(@Param("roundIds") List<Integer> roundIds ,@Param("courseId") int courseId);

    List<Seminar> getSeminarByCourseID(int course_id);

}
