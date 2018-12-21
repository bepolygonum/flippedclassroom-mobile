package com.service.impl;

import com.dao.RoundDao;
import com.dao.RoundScoreDao;
import com.dao.SeminarDao;
import com.entity.Round;
import com.entity.RoundScore;
import com.entity.Seminar;
import com.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "RoundService")
public class RoundServiceImpl implements RoundService {
    @Autowired
    RoundDao roundDao;
    @Autowired
    RoundScoreDao roundScoreDao;
    @Autowired
    SeminarDao seminarDao;

    public List<RoundScore> getRoundScoreByCourseID(int courseId)
    {
        List<Round> rounds = roundDao.getRoundByCourseID(courseId);//根据课程id获得所有rounds
        List<Integer> roundIds=rounds.stream().map(Round::getId).collect(Collectors.toList());//所有rounds的id集合
        List<RoundScore> roundScores=roundScoreDao.getRoundScoreByRoundID(roundIds);//某课程下所有rounds的成绩
        return roundScores;
    }

    public List<Seminar>  getSeminarByRoundID(List<Integer> roundIds,int courseId)
    {
        List<Seminar> seminars=seminarDao.getSeminarByRoundID(roundIds,courseId);
        //List<Integer> seminarIds=seminars.stream().map(Seminar::getId).collect(Collectors.toList());//某课程下所有seminar的id
        return seminars;
    }


}
