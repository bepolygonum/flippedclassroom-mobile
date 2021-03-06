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


    public Klass getKlassByKlassID(int klassId) {
        return klassDao.getKlassByKlassID(klassId);
    }

    public List<KlassSeminar> getKlassSeminarBySeminarID(List<Integer> seminarIds){return klassSeminarDao.getKlassSeminarBySeminarID(seminarIds);}

    public List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(int klassId, int seminarid) {
        List list=new ArrayList(),list1=new ArrayList();
        list.add(klassId);
        list1.add(seminarid);
        return klassSeminarDao.getKlassSeminarByKlassIdSeminarID(list,list1);
    }

    public void createAKlass(int courseId,int grade,int klassSerial,String klassTime,String location)
    { klassDao.createAKlass(courseId,grade,klassSerial,klassTime,location);}

}
