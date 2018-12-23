package com.service;

import com.dao.KlassDao;
import com.dao.KlassSeminarDao;
import com.dao.KlassStudentDao;
import com.dao.SeminarScoreDao;
import com.entity.Klass;
import com.entity.KlassSeminar;
import com.entity.KlassStudent;
import com.entity.SeminarScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service(value = "KlassService")
public class KlassServiceImpl {
    @Autowired
    KlassDao klassDao;
    @Autowired
    KlassStudentDao klassStudentDao;
    @Autowired
    KlassSeminarDao klassSeminarDao;
    @Autowired
    SeminarScoreDao seminarScoreDao;

    public List<SeminarScore> getSeminarScoreByCourseSeminarID(int courseId, List<Integer> seminarIds)
    {
        //根据课程id获得所有班级id
        List<Integer> klassIds=klassDao.getKlassIDByCourseID(courseId);
        List<Integer> klassSeminarIds=klassSeminarDao.getKlassSeminarIDByKlassIdSeminarID(klassIds,seminarIds);
        List<SeminarScore> seminarScores=seminarScoreDao.getSeminarScoreByKlassSeminarID(klassSeminarIds);
        System.out.print(seminarScores.get(0).getPresentation_score());
        return  seminarScores;
    }

    public List<KlassSeminar> getKlassSeminarByCourseSeminarID(int courseId, List<Integer> seminarIds)
    {
        //根据课程id获得所有班级id
        List<Integer> klassIds=klassDao.getKlassIDByCourseID(courseId);
        List<KlassSeminar> klassSeminars=klassSeminarDao.getKlassSeminarByKlassIdSeminarID(klassIds,seminarIds);
        return klassSeminars;
    }

    public List<Klass> getKlassByStudentID(int id) {
        List klassid=klassDao.getKlassIDByStudentID(id);
        List<Klass> klasses=new ArrayList<Klass>();
        Iterator it = klassid.iterator();
        while(it.hasNext()){
            klasses.add(klassDao.getKlassByKlassID(Integer.valueOf(it.next().toString())));
        }
        return  klasses;
    }

    public List<KlassStudent> getKlassStudentByCourseID(int courseId)
    {
        return klassStudentDao.getKlassStudentByCourseID(courseId);
    }


    public List<Klass> getKlassByCourseID(int courseId)
    {
        return klassDao.getKlassByCourseID(courseId);
    }


    public List<KlassStudent> getKlassStudentByStudentIdAndKlassId(int studentId, int klassid) {
        return klassStudentDao.getKlassStudentByStudentIdAndKlassId(studentId,klassid);
    }


    public List<KlassStudent> getKlassStudentByTeamID(int team_id, int courseId) {
        return klassStudentDao.getKlassStudentByTeamID(team_id,courseId);
    }


    public List<KlassStudent> getKlassStudentWithNoTeam(int courseId) {
        return klassStudentDao.getKlassStudentWithNoTeam(courseId);
    }

    public Klass getKlassByKlassID(int klassId) {
        return klassDao.getKlassByKlassID(klassId);
    }

    public List<KlassSeminar> getKlassSeminarBySeminarID(List<Integer> seminarIds){return klassSeminarDao.getKlassSeminarBySeminarID(seminarIds);}

}
