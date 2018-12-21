package com.service.impl;

import com.dao.KlassDao;
import com.dao.KlassSeminarDao;
import com.dao.SeminarScoreDao;
import com.entity.KlassSeminar;
import com.entity.SeminarScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "KlassService")
public class KlassServiceImpl {
    @Autowired
    KlassDao klassDao;
    @Autowired
    KlassSeminarDao klassSeminarDao;
    @Autowired
    SeminarScoreDao seminarScoreDao;
    public List<SeminarScore> getSeminarScoreByCourseSeminarID(int courseId,List<Integer> seminarIds)
    {
        List<Integer> klassIds=klassDao.getKlassIDByCourseID(courseId);//根据课程id获得所有班级id
        List<Integer> klassSeminarIds=klassSeminarDao.getKlassSeminarIDByKlassIdSeminarID(klassIds,seminarIds);
        List<SeminarScore> seminarScores=seminarScoreDao.getSeminarScoreByKlassSeminarID(klassSeminarIds);
        System.out.print(seminarScores.get(0).getPresentation_score());
        return  seminarScores;
    }

    public List<KlassSeminar> getKlassSeminarByCourseSeminarID(int courseId,List<Integer> seminarIds)
    {
        List<Integer> klassIds=klassDao.getKlassIDByCourseID(courseId);//根据课程id获得所有班级id
        List<KlassSeminar> klassSeminars=klassSeminarDao.getKlassSeminarByKlassIdSeminarID(klassIds,seminarIds);
        return klassSeminars;
    }

}
