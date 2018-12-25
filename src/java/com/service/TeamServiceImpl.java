package com.service;

import com.dao.KlassDao;
import com.dao.KlassStudentDao;
import com.dao.TeamDao;
import com.entity.KlassStudent;
import com.entity.Student;
import com.entity.Team;
import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KEKE
 */
@Service(value = "TeamService")
public class TeamServiceImpl  {
    @Autowired
    TeamDao teamDao;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    KlassStudentDao klassStudentDao;
    @Autowired
    KlassDao klassDao;
    public List<Team> getTeamByCourseID(int courseId)
    {
        //根据课程id获得所有team
        List<Team> teams=teamDao.getTeamByCourseID(courseId);
        return teams;
    }

    public Team getTeamById(int teamid) {
        return teamDao.getTeamById(teamid);
    }

    public List <Integer>getTeamIdByStudentIdAndCourseId(int id,int courseid) {
        List <Integer> list1=teamDao.getTeamIdByStudentId(id);
        List klassIds=klassDao.getKlassIDByCourseID(courseid);
        List teamList=teamDao.getTeamIdByKlassId(klassIds);
        list1.retainAll(teamList);
        return list1;
    }

    public List<Student> getStudentByTeamID(int id) {
        List students=teamDao.getStudentIdByTeamId(id);
        if(students.size()==0){
            return null;
        }
        else {return studentService.getStudentByStudentID(students);}
    }

    public List<Student> getStudentWithNoTeams(List<List<Student>> listOfStudents, int courseId) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            for (int j = 0; j < listOfStudents.get(i).size(); j++) {
                studentList.add(listOfStudents.get(i).get(j));
            }
        }
        List list=new ArrayList();
        List<KlassStudent> klassStudent=klassStudentDao.getKlassStudentByCourseID(courseId);
        for(int i=0;i<klassStudent.size();i++){
            list.add(klassStudent.get(i).getStudentId());
        }
        List<Student> allStudents=studentService.getStudentByStudentID(list);

        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < allStudents.size(); j++) {
                if(studentList.get(i).getId()==allStudents.get(j).getId()){
                    allStudents.remove(j);}
            }
        }
        return allStudents;
    }

    public List getTeamIdByKlassId(List klassIds) {
        return teamDao.getTeamIdByKlassId(klassIds);
    }

    public List<Team> getTeamByIds(List ids) {
        return teamDao.getTeamByIds(ids);
    }
}
