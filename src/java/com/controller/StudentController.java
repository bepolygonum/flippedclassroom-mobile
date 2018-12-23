package com.controller;

import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author KEKE
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private RoundServiceImpl roundService;
    @Autowired
    private KlassServiceImpl klassService;
    @Autowired
    private SeminarServiceImpl seminarService;
    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private CourseMemberLimitStrategyServiceImpl courseMemberLimitStrategyService;

    @RequestMapping(value = "/courseManage", method = RequestMethod.POST)
    public String courseManage(Model model, @RequestParam (name="id") String sid,@RequestParam String name)  {
        int id=Integer.valueOf(sid);
        List<Klass> klassList = klassService.getKlassByStudentID(id);
        System.out.println(klassList);
        List<Course> courseList = courseService.getCourseByStudentID(id);
        System.out.println(courseList);
        model.addAttribute(courseList);
        model.addAttribute(klassList);
        Student student=new Student();
        student.setId(id);
        student.setStudentName(name);
        model.addAttribute(student);
        return "/student/courseManage";
    }
    @RequestMapping(value = "/courseInfo", method = RequestMethod.POST)
    public String courseInfo(Model model, @RequestParam(name = "id") String sid,@RequestParam String name,@RequestParam (name="course_id")String courseid)  {
        int id=Integer.valueOf(sid);
        int courseId=Integer.valueOf(courseid);
        Course course=courseService.getCourseByCourseID(courseId);
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseMemberLimitStrategyService.getCourseMemberLimitStrategyByCourseID(courseId);
        Student student=new Student();
        student.setId(id);
        student.setStudentName(name);
        model.addAttribute(student);
        model.addAttribute(course);
        model.addAttribute(courseMemberLimitStrategy);
        return "student/course/courseInfo";
    }
    @RequestMapping(value = "/courseScore", method = RequestMethod.POST)
    public String courseScore(Model model, @RequestParam (name = "klass_id")String klassid,@RequestParam(name = "id") String sid,@RequestParam String name,@RequestParam (name = "course_id")String courseid)  {
        int id=Integer.valueOf(sid);
        int courseId=Integer.valueOf(courseid);
        int klassId=Integer.valueOf(klassid);
        //获取course
        Course course=courseService.getCourseByCourseID(courseId);
        //获取team_id
        int teamid=studentService.getTeamIdByStudentId(id,courseId);
        //获取该课程所有的seminar
        List<Seminar> seminarList=seminarService.getSeminarByCourseID(courseId);
        //获取klass
        Klass klass=klassService.getKlassByKlassID(klassId);
        //获取该team该班级的score
        List<SeminarScore> seminarScoreList=seminarService.getSeminarScoreByTeamIdAndKlassId(teamid,klassId);
        //获取本轮总成绩
        List<RoundScore> roundScoreList=roundService.getRoundScoreByCourseID(courseId);
        Iterator<RoundScore> it = roundScoreList.iterator();
        while(it.hasNext()){
            RoundScore x = it.next();
            if(x.getTeamId()!=teamid){
                it.remove();
            }
        }
        Student student=new Student();
        student.setId(id);
        student.setStudentName(name);
        model.addAttribute(student);
        model.addAttribute(roundScoreList);
        model.addAttribute(seminarList);
        model.addAttribute(seminarScoreList);
        model.addAttribute(klass);
        model.addAttribute(course);
        return "student/course/courseScore";
    }

    @RequestMapping(value = "/courseTeam", method = RequestMethod.POST)
    public String courseTeam(Model model, @RequestParam(name = "klass_id") String klassid,@RequestParam(name = "id") String sid,@RequestParam String name,@RequestParam (name = "course_id")String courseid) {
        int id=Integer.valueOf(sid);
        int courseId=Integer.valueOf(courseid);
        int klassId=Integer.valueOf(klassid);
        int teamid;
        Team myteam=new Team();
        Student student=studentService.getStudentByID(id);
        model.addAttribute(student);
        model.addAttribute("course",courseService.getCourseByCourseID(courseId));
        //查出所有team ，未组队的人，本team成员
        // 找到teamid
        List<KlassStudent> klassStudents=klassService.getKlassStudentByStudentIdAndKlassId(id,klassId);
        Klass klass=klassService.getKlassByKlassID(klassId);
        model.addAttribute(klass);
        if(klassStudents!=null) {
            teamid = klassStudents.get(0).getTeamId();
            //course下所有team
            List<Team> teamList=teamService.getTeamByCourseID(courseId);
            if(teamList.size()!=0) {
                model.addAttribute(teamList);
            }
            //添加所有队伍
            System.out.println(teamList.size());
            List<List<Student>> listOfStudents = new ArrayList<List<Student>>();
            for (int i=0;i<teamList.size();i++){
                List<KlassStudent> members=klassService.getKlassStudentByTeamID(teamList.get(i).getId(),courseId);
                List studentIds=new ArrayList() ;
                for (int j=0;j<members.size();j++) {
                    studentIds.add(members.get(j).getStudentId());
                }
                listOfStudents.add(studentService.getStudentByStudentID(studentIds));
            }
            if(listOfStudents!=null) {
                model.addAttribute(listOfStudents);
            }
            //未组队的人
            List<KlassStudent> noTeam=klassService.getKlassStudentWithNoTeam(courseId);
            List studentids=new ArrayList() ;
            for (int j=0;j<noTeam.size();j++) {
                studentids.add(noTeam.get(j).getStudentId());
            }
            List<Student>noTeams;
            if(noTeam.size()>0)
            {
                noTeams=studentService.getStudentByStudentID(studentids);
                model.addAttribute("noTeams",noTeams);
            }

            if(teamid==0) {
                return "student/course/team/createTeam";
            }
            //找到team leader
            myteam = teamService.getTeamById(teamid);
            if(myteam!=null) {
                model.addAttribute("myteam",myteam);
            }
            //找到同course下的本小组成员
            List<KlassStudent> teamMember=klassService.getKlassStudentByTeamID(teamid,courseId);
            List memberids=new ArrayList() ;
            for (int j=0;j<teamMember.size();j++) {
                memberids.add(teamMember.get(j).getStudentId());
            }
            List<Student> memberTeam=studentService.getStudentByStudentID(memberids);
            if(memberTeam.size()!=0) {
                model.addAttribute("memberTeam",memberTeam);
            }
            if(myteam.getLeaderId()==id)
            {
                return "student/course/team/leaderTeam";
            }
            else {
                return "student/course/team/memberTeam";
            }
        }
        else {
            return "";
        }
        }
    }
