package com.controller;

import com.entity.*;
import com.service.TeamService;
import com.service.impl.CourseServiceImpl;
import com.service.impl.KlassServiceImpl;
import com.service.impl.RoundServiceImpl;
import com.service.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller

public class TeacherController {
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private KlassServiceImpl klassService;
    @Autowired
    private RoundServiceImpl roundService;
    @Autowired
    private TeamServiceImpl teamService;

    @RequestMapping(value = "/courseManage", method = RequestMethod.POST)
    public String findCourse(Model model, @RequestParam String id ) {
        int tid=Integer.parseInt(id);
        List<Course> courseList = courseService.getCoursebyTeacherID(tid);
        model.addAttribute(courseList);
        model.addAttribute("id",tid);
        return "courseManage";
    }

    @RequestMapping(value = "/teacher/course/grade")
    public String findAllGrade(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int course_id=Integer.parseInt(courseId);

        List<RoundScore> roundScoreList=roundService.getRoundScoreByCourseID(course_id);

        List<Integer> roundIds=roundScoreList.stream().map(RoundScore::getRound_id).collect(Collectors.toList());//所有rounds的id集合
        List<Seminar> seminarList=roundService.getSeminarByRoundID(roundIds,course_id);

        List<Integer> seminarIds=seminarList.stream().map(Seminar::getId).collect(Collectors.toList());//某课程下所有seminar的id
        List<SeminarScore> seminarScoreList=klassService.getSeminarScoreByCourseSeminarID(course_id,seminarIds);
        List<KlassSeminar> klassSeminarList=klassService.getKlassSeminarByCourseSeminarID(course_id,seminarIds);

        List<Team> teamList=teamService.getTeamByCourseID(course_id);

        model.addAttribute(roundScoreList);
        model.addAttribute(seminarList);
        model.addAttribute(seminarScoreList);
        model.addAttribute(klassSeminarList);
        model.addAttribute(teamList);
        model.addAttribute("id",tid);


        return "/teacher/course/grade";
    }

}
