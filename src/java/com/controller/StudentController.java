package com.controller;

import com.entity.*;
import com.service.RoundService;
import com.service.SeminarService;
import com.service.TeamService;
import com.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;


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
    private SeminarService seminarService;
    @Autowired
    private CourseMemberLimitStrategyServiceImpl courseMemberLimitStrategyService;
    @RequestMapping(value = "/courseManage", method = RequestMethod.POST)
    public String courseManage(Model model, @RequestParam String id,@RequestParam String name)  {
        int Id=Integer.valueOf(id);
        List<Klass> klassList = klassService.getKlassByStudentID(Id);
        List<Course> courseList = courseService.getCourseByStudentID(Id);
        model.addAttribute(courseList);
        model.addAttribute(klassList);
        Student student=new Student();
        student.setId(Id);
        student.setStudent_name(name);
        model.addAttribute(student);
        return "/student/courseManage";
    }
    @RequestMapping(value = "/courseInfo", method = RequestMethod.POST)
    public String courseInfo(Model model, @RequestParam String id,@RequestParam String name,@RequestParam String course_id)  {
        int Id=Integer.valueOf(id);
        int courseId=Integer.valueOf(course_id);
        Course course=courseService.getCourseByCourseID(courseId);
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseMemberLimitStrategyService.getCourseMemberLimitStrategyByCourseID(courseId);
        Student student=new Student();
        student.setId(Id);
        student.setStudent_name(name);
        model.addAttribute(student);
        model.addAttribute(course);
        model.addAttribute(courseMemberLimitStrategy);
        return "/student/courseInfo";
    }
    @RequestMapping(value = "/courseScore", method = RequestMethod.POST)
    public String courseScore(Model model, @RequestParam String klass_id,@RequestParam String id,@RequestParam String name,@RequestParam String course_id)  {
        int Id=Integer.valueOf(id);
        int courseId=Integer.valueOf(course_id);
        int klassId=Integer.valueOf(klass_id);

        int team_id=studentService.getTeamIdByStudentId(Id,courseId);//获取team_id
        List<Seminar> seminarList=seminarService.getSeminarByCourseID(courseId);//获取该课程所有的seminar

        List<SeminarScore> seminarScoreList=seminarService.getSeminarScoreByTeamIdAndKlassId(team_id,klassId);//获取该team该班级的score
        System.out.println("asdsf");
        List<RoundScore> roundScoreList=roundService.getRoundScoreByCourseID(courseId);//获取本轮总成绩
        System.out.println("asdsf");
        Iterator<RoundScore> it = roundScoreList.iterator();
        while(it.hasNext()){
            RoundScore x = it.next();
            if(x.getTeam_id()==team_id){
                it.remove();
            }
        }
        Student student=new Student();
        student.setId(Id);
        student.setStudent_name(name);
        model.addAttribute(student);
        model.addAttribute(roundScoreList);
        model.addAttribute(seminarList);
        model.addAttribute(seminarScoreList);
        model.addAttribute("klass_id",klass_id);
        model.addAttribute("course_id",course_id);
        return "/student/courseScore";
    }
}
