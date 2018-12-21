package com.dao;

import com.entity.Team;

import java.util.List;

public interface TeamDao {
    List<Team> getTeamByCourseID(int courseId);
}
