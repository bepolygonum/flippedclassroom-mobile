package com.dao;

import com.entity.Seminar;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface SeminarDao {
    //List<Seminar> getSeminarByRoundID(HashMap<List<Integer>,Integer> seminarParams);
    List<Seminar> getSeminarByRoundID(@Param("roundIds") List<Integer> roundIds ,@Param("courseId") int courseId);

}
