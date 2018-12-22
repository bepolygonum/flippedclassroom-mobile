package com.controller;

import com.dao.ConflictCourseStrategyDao;
import com.entity.*;
import com.service.StudentService;
import com.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller

@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private KlassServiceImpl klassService;
    @Autowired
    private RoundServiceImpl roundService;
    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherServiceImpl teacherService;



    @RequestMapping(value = "/courseManage", method = RequestMethod.POST)
    public String findCourse(Model model, @RequestParam String id ) {
        int tid=Integer.parseInt(id);
        List<Course> courseList = courseService.getCourseByTeacherID(tid);
        model.addAttribute(courseList);
        model.addAttribute("id",tid);
        return "teacher/courseManage";
    }

    @RequestMapping(value = "/course/grade")
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

        List<Klass> klassList=klassService.getKlassByCourseID(course_id);

        model.addAttribute(roundScoreList);
        model.addAttribute(seminarList);
        model.addAttribute(seminarScoreList);
        model.addAttribute(klassSeminarList);
        model.addAttribute(teamList);
        model.addAttribute("id",tid);
        model.addAttribute(klassList);
        return "/teacher/course/grade";
    }

    @RequestMapping(value = "/course/teamList")
    public String findAllTeam(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int course_id=Integer.parseInt(courseId);
        List<KlassStudent> klassStudentList=klassService.getKlassStudentByCourseID(course_id);
        List<Team> teamList=teamService.getTeamByCourseID(course_id);

        List<Integer> studentIds=klassStudentList.stream().map(KlassStudent::getStudent_id).collect(Collectors.toList());//某课程下所有学生的id
        List<Student> studentList=studentService.getStudentByStudentID(studentIds);

        List<Klass> klassList=klassService.getKlassByCourseID(course_id);

        model.addAttribute(teamList);
        model.addAttribute(klassStudentList);
        model.addAttribute(studentList);
        model.addAttribute(klassList);
        model.addAttribute("id",tid);
        return "/teacher/course/teamList";
    }

    @RequestMapping(value = "/course/info")
    public String findCourseInfo(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int course_id=Integer.parseInt(courseId);
        List<Course> courseList=courseService.getConflictCourseByCourseID(course_id);
        Course course=courseService.getCourseByCourseID(course_id);
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseService.getCourseMemberLimitByCourseID(course_id);
        List<Integer> teacherIds=courseList.stream().map(Course::getTeacher_id).collect(Collectors.toList());
        List<Teacher> teacherList=teacherService.getTeachersByTeacherID(teacherIds);
        model.addAttribute(courseList);
        model.addAttribute(course);
        model.addAttribute(teacherList);
        model.addAttribute(courseMemberLimitStrategy);
        model.addAttribute("id",tid);
        return "/teacher/course/info";
    }
}
