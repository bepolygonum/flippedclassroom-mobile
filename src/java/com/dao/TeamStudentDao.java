package com.dao;

import com.entity.TeamStudent;

import java.util.List;

public interface TeamStudentDao {
    List<TeamStudent> getTeamStudentsByTeamIds(List<Integer> teamIds);
}
