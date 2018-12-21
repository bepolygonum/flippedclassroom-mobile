package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service(value = "CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    RoundDao roundDao;
    @Autowired
    RoundScoreDao roundScoreDao;
    @Autowired
    KlassDao klassDao;
    @Autowired
    SeminarDao seminarDao;



    @Override
    public List<Course> getCoursebyTeacherID(int id)
    {
        return courseDao.getCoursebyTeacherID(id);
    }

    //@Override
    //public void getAllRoundScoreByCourseID(int courseId)
    //{
        //List<Team> teams=teamDao.getTeamByCourseID(courseId);//根据课程id获得所有team

        //List<Round> rounds = roundDao.getRoundByCourseID(courseId);//根据课程id获得所有rounds
        //List<Integer> roundIds=rounds.stream().map(Round::getId).collect(Collectors.toList());//所有rounds的id集合
        //List<RoundScore> roundScores=roundScoreDao.getRoundScoreByRoundID(roundIds);//某课程下所有rounds的成绩

        //List<Seminar> seminars=seminarDao.getSeminarByRoundID(roundIds,courseId);
        //List<Integer> seminarIds=seminars.stream().map(Seminar::getId).collect(Collectors.toList());//某课程下所有seminar的id

        //List<Integer> klassIds=klassDao.getKlassIDByCourseID(courseId);//根据课程id获得所有班级id
        //List<Integer> klassSeminarIds=klassSeminarDao.getKlassSeminarIDByKlassIdSeminarID(klassIds,seminarIds);
        //List<SeminarScore> seminarScores=seminarScoreDao.getSeminarScoreByKlassSeminarID(klassSeminarIds);


    //}
}
