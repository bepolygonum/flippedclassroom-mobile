package com.service;

import com.dao.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    KlassServiceImpl klassService;
    @Autowired
    AttendanceDao attendanceDao;

    public List<Seminar> getSeminarByCourseID(int courseId) {
        return seminarDao.getSeminarByCourseID(courseId);
    }

    public List<SeminarScore> getSeminarScoreByTeamIdAndKlassId(int teamid, int klassId) {

        List<Integer> klassSeminarId=klassSeminarDao.getKlassSeminarIDByKlassId(klassId);
        if(klassSeminarId.isEmpty())
        {
            return null;
        }
        List <SeminarScore> seminarScores= seminarScoreDao.getSeminarScoreByKlassSeminarID(klassSeminarId);
        Iterator<SeminarScore> it = seminarScores.iterator();
        while(it.hasNext()){
            SeminarScore x = it.next();
            if(x.getTeamId()!=teamid){
                it.remove();
            }
        }
        return seminarScores;
    }

    public Seminar getSeminarBySeminarId(int seminarid) {
        return seminarDao.getSeminarBySeminarID(seminarid);
    }

    public List<KlassSeminar> getSeminarStatusBySeminarAndStudentID(Seminar seminar, int id) {
        List<Klass> klasses=klassService.getKlassByStudentID(id);
        Klass klass = new Klass();
        for(int i=0;i<klasses.size();i++)
        {
            if(klasses.get(i).getCourseId()==seminar.getCourseId()){
                klass=klasses.get(i);
                break;
            }
        }
        List list=new ArrayList() ;
        List list1=new ArrayList() ;
        list.add(klass.getId());
        list1.add(seminar.getId());
        return  klassSeminarDao.getKlassSeminarByKlassIdSeminarID(list,list1);
    }

    public void insertEnrollByTeamIdAndSeminarId(int teamid, int seminarid,int order) {
        seminarScoreDao.insertEnrollByTeamIdAndSeminarId(teamid,seminarid);
        attendanceDao.insertAttendByTeamIdAndSeminarId(teamid,seminarid,order);
    }

    public List<Attendance> getAttendanceByKlassSeminarId(int klassSeminarId) {
        return  attendanceDao.getAttendanceByKlassSeminarId(klassSeminarId);

    }
}