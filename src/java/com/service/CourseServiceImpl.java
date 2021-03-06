package com.service;

import com.dao.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author KEKE
 */
@SuppressWarnings("ALL")
@Service(value = "CourseService")
public class CourseServiceImpl  {
    @Autowired
    CourseDao courseDao;
    @Autowired
    RoundDao roundDao;
    @Autowired
    ConflictCourseStrategyDao conflictCourseStrategyDao;
    @Autowired
    RoundScoreDao roundScoreDao;
    @Autowired
    KlassDao klassDao;
    @Autowired
    SeminarDao seminarDao;
    @Autowired
    CourseMemberLimitStrategyDao courseMemberLimitStrategyDao;

    public List<Course> getCourseByTeacherID(int id)
    {
        return courseDao.getCourseByTeacherID(id);
    }


    public List<Course> getConflictCourseByCourseID(int courseId)
    {
        List<Integer> course1ID=conflictCourseStrategyDao.getCourse1IDByCourseID(courseId);
        List<Integer> course2ID=conflictCourseStrategyDao.getCourse2IDByCourseID(courseId);
        course1ID.removeAll(course2ID);
        course1ID.addAll(course2ID);
        List<Course> conflictCourseList;
        conflictCourseList = courseDao.getCoursesByCourseID(course1ID);
        return conflictCourseList;
    }


    public List<Course> getCourseByStudentID(int id){
        List list = courseDao.getCourseByStudentID(id);
        List<Course> courses=new ArrayList<Course>();
        Iterator it = list.iterator();
        while(it.hasNext()){
            courses.add(courseDao.getCourseByCourseID(Integer.valueOf(it.next().toString())));
        }
        return courses;
    }


    public Course getCourseByCourseID(int courseid) {
        return courseDao.getCourseByCourseID(courseid);
    }


    public CourseMemberLimitStrategy getCourseMemberLimitByCourseID(int courseId)
    {
        return courseMemberLimitStrategyDao.getCourseMemberLimitStrategyByCourseID(courseId);
    }

    public List<Course> getCourseBySeminarMainCourseID(int id)
    {
        return courseDao.getCourseBySeminarMainCourseID(id);
    }

    public List<Course> getCourseByTeamMainCourseID(int id){return courseDao.getCourseByTeamMainCourseID(id);}


    public Integer getConflictIdByCourseID(int courseId){return conflictCourseStrategyDao.getIdByCourseID(courseId);}

    public List<Integer> getConflictCourseIdByID(int cid) {return conflictCourseStrategyDao.getCourseIdByID(cid);}

    public List<Course> getCoursesByCourseID(List<Integer> courseIds)
    {return courseDao.getCoursesByCourseID(courseIds);}

    public List<Course> getAllCourses() {return courseDao.getAllCourses();}

    public Course getCourseByCourseName(String courseName) {return courseDao.getCourseByCourseName(courseName);}

    public void createACourse(int teacherId, String courseName, String introduction, int presentationPercentage, int questionPercentage, int reportPercentage, Timestamp teamStartTime, Timestamp teamEndTime)
    { courseDao.createACourse(teacherId,courseName,introduction,presentationPercentage,questionPercentage,reportPercentage,teamStartTime,teamEndTime);}

    public List<Integer> getAllConflictId() {return conflictCourseStrategyDao.getAllConflictId();}

    public void createConflictCourse(int id,int course1Id,int course2Id)
    {
        conflictCourseStrategyDao.createHarfOfConflictCourse(id,course1Id);
        conflictCourseStrategyDao.createHarfOfConflictCourse(id,course2Id);
    }
}
