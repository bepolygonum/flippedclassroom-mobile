package com.service.impl;

import com.dao.*;
import com.entity.KlassSeminar;
import com.entity.RoundScore;
import com.entity.Seminar;
import com.entity.SeminarScore;
import com.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service(value = "SeminarService")
public class SeminarServiceImpl implements SeminarService {
    @Autowired
    SeminarDao seminarDao;
    @Autowired
    SeminarScoreDao seminarScoreDao;
    @Autowired
    KlassSeminarDao klassSeminarDao;
    @Override
    public List<Seminar> getSeminarByCourseID(int courseId) {
        return seminarDao.getSeminarByCourseID(courseId);
    }

    @Override
    public List<SeminarScore> getSeminarScoreByTeamIdAndKlassId(int team_id, int klassId) {

        List seminarid=klassSeminarDao.getKlassSeminarIDByKlassId(klassId);
        List <SeminarScore> seminarScores= seminarScoreDao.getSeminarScoreByKlassSeminarID(seminarid);
        Iterator<SeminarScore> it = seminarScores.iterator();
        while(it.hasNext()){
            SeminarScore x = it.next();
            if(x.getTeam_id()!=team_id){
                it.remove();
            }
        }
        return seminarScores;
    }
}