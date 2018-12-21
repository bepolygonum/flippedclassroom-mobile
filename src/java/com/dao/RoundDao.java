package com.dao;

import com.entity.Round;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoundDao {
    List<Round> getRoundByCourseID(int courseId);

}
