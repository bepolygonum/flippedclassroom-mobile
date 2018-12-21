package com.service;

import com.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getTeamByCourseID(int courseId);
}
