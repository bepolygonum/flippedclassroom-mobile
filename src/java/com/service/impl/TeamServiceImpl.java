package com.service.impl;

import com.dao.TeamDao;
import com.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TeamService")
public class TeamServiceImpl {
    @Autowired
    TeamDao teamDao;

    public List<Team> getTeamByCourseID(int courseId)
    {
        List<Team> teams=teamDao.getTeamByCourseID(courseId);//根据课程id获得所有team
        return teams;
    }

}
