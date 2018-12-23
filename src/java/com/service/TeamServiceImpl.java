package com.service;

import com.dao.TeamDao;
import com.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TeamService")
public class TeamServiceImpl  {
    @Autowired
    TeamDao teamDao;

    public List<Team> getTeamByCourseID(int courseId)
    {
        //根据课程id获得所有team
        List<Team> teams=teamDao.getTeamByCourseID(courseId);
        return teams;
    }

    public Team getTeamById(int team_id) {
        return teamDao.getTeamById(team_id);
    }
}
