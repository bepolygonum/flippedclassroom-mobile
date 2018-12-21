package com.dao;

import com.entity.Round;

import java.util.List;

public interface RoundDao {
    List<Round> getRoundByCourseID(int courseId);

}
