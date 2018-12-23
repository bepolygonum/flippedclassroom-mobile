package com.dao;

import com.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamDao {
    List<Team> getTeamByCourseID(int courseId);
    Team getTeamById(int team_id);
}
