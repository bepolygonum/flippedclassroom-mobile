package com.service;

import com.dao.*;
import com.entity.Seminar;
import com.entity.SeminarScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author KEKE
 */
@Service(value = "SeminarService")
public class SeminarServiceImpl {
    @Autowired
    SeminarDao seminarDao;
    @Autowired
    SeminarScoreDao seminarScoreDao;
    @Autowired
    KlassSeminarDao klassSeminarDao;

    public List<Seminar> getSeminarByCourseID(int courseId) {
        return seminarDao.getSeminarByCourseID(courseId);
    }

    public List<SeminarScore> getSeminarScoreByTeamIdAndKlassId(int teamid, int klassId) {

        List seminarid=klassSeminarDao.getKlassSeminarIDByKlassId(klassId);
        List <SeminarScore> seminarScores= seminarScoreDao.getSeminarScoreByKlassSeminarID(seminarid);
        Iterator<SeminarScore> it = seminarScores.iterator();
        while(it.hasNext()){
            SeminarScore x = it.next();
            if(x.getTeamId()!=teamid){
                it.remove();
            }
        }
        return seminarScores;
    }
}