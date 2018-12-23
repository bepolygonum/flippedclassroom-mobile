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
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KEKE
 */
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
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private SeminarServiceImpl seminarService;



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
        int courseid=Integer.parseInt(courseId);

        List<RoundScore> roundScoreList=roundService.getRoundScoreByCourseID(courseid);
        //所有rounds的id集合
        List<Integer> roundIds=roundScoreList.stream().map(RoundScore::getRoundId).collect(Collectors.toList());
        List<Seminar> seminarList=roundService.getSeminarByRoundID(roundIds,courseid);
        //某课程下所有seminar的id
        List<Integer> seminarIds=seminarList.stream().map(Seminar::getId).collect(Collectors.toList());
        List<SeminarScore> seminarScoreList=klassService.getSeminarScoreByCourseSeminarID(courseid,seminarIds);
        List<KlassSeminar> klassSeminarList=klassService.getKlassSeminarByCourseSeminarID(courseid,seminarIds);

        List<Team> teamList=teamService.getTeamByCourseID(courseid);

        List<Klass> klassList=klassService.getKlassByCourseID(courseid);

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
        int courseid=Integer.parseInt(courseId);
        List<KlassStudent> klassStudentList=klassService.getKlassStudentByCourseID(courseid);
        List<Team> teamList=teamService.getTeamByCourseID(courseid);
//某课程下所有学生的id
        List<Integer> studentIds=klassStudentList.stream().map(KlassStudent::getStudentId).collect(Collectors.toList());
        List<Student> studentList=studentService.getStudentByStudentID(studentIds);

        List<Klass> klassList=klassService.getKlassByCourseID(courseid);

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
        int courseid=Integer.parseInt(courseId);
        List<Course> courseList=courseService.getConflictCourseByCourseID(courseid);
        Course course=courseService.getCourseByCourseID(courseid);
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseService.getCourseMemberLimitByCourseID(courseid);

        List<Integer> teacherIds=courseList.stream().map(Course::getTeacherId).collect(Collectors.toList());
        List<Teacher> teacherList=teacherService.getTeachersByTeacherID(teacherIds);

        model.addAttribute(courseList);
        model.addAttribute(course);
        model.addAttribute(teacherList);
        model.addAttribute(courseMemberLimitStrategy);
        model.addAttribute("id",tid);
        return "/teacher/course/info";
    }

    @RequestMapping(value = "/course/createCourse")
    public String createCourse(Model model,@RequestParam String id)
    {
        int tid=Integer.parseInt(id);
        model.addAttribute("id",tid);
        return "/teacher/course/createCourse";
    }

    /*
    @RequestMapping(value = "/course/createCourse",method = RequestMethod.POST)
    public String CreateACourse(Model model,@RequestParam String id,@RequestParam String courseName,)//
    {
        int tid=Integer.parseInt(id);
        model.addAttribute("id",tid);
        return "/teacher/course/createCourse";
    }
    */

    @RequestMapping(value = "/course/klassList")
    public String findAllKlasses(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        List<Klass> klassList=klassService.getKlassByCourseID(courseid);
        model.addAttribute(klassList);
        model.addAttribute("courseId",courseid);
        model.addAttribute("id",tid);
        return "/teacher/course/klassList";
    }

    @RequestMapping(value = "/course/klass/create")
    public String createKlass(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        model.addAttribute("courseId",courseid);
        model.addAttribute("id",tid);
        return "/teacher/course/klass/create";

    }

    @RequestMapping(value = "/course/seminar")
    public String findAllSeminar(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        Course course=courseService.getCourseByCourseID(courseid);
        List<Round> roundList=roundService.getRoundByCourseID(courseid);
        List<Seminar> seminarList=seminarService.getSeminarByCourseID(courseid);
        List<Klass> klassList=klassService.getKlassByCourseID(courseid);

        List<Integer> seminarIds=seminarList.stream().map(Seminar::getId).collect(Collectors.toList());
        List<KlassSeminar> klassSeminarList=klassService.getKlassSeminarBySeminarID(seminarIds);

        model.addAttribute(course);
        model.addAttribute(roundList);
        model.addAttribute(seminarList);
        model.addAttribute(klassList);
        model.addAttribute(klassSeminarList);
        model.addAttribute("id",tid);
        return "teacher/course/seminarList";
    }

    @RequestMapping(value = "/course/share")
    public String findAllShare(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        List<Teacher> teacherList1=new ArrayList<>();
        List<Teacher> teacherList2=new ArrayList<>();
        Course course=courseService.getCourseByCourseID(courseid);
        //course为主课程
        int seminarMainCourseId=course.getSeminarMainCourseId();
        int teamMainCourseId=course.getTeamMainCourseId();
        List<Course> seminarCourseList=new ArrayList<>();
        Course seminarMainCourse=new Course();
        List<Course> teamCourseList=new ArrayList<>();
        Course teamMainCourse=new Course();
        if (seminarMainCourseId!=0)
        {
            if(seminarMainCourseId==courseid)
            {
                seminarCourseList=courseService.getCourseBySeminarMainCourseID(courseid);
                List<Integer> teacherIds=seminarCourseList.stream().map(Course::getTeacherId).collect(Collectors.toList());
                if(!teacherIds.isEmpty()){
                teacherList1.addAll(teacherService.getTeachersByTeacherID(teacherIds));
                }
            }
            else
            {
                seminarMainCourse=courseService.getCourseByCourseID(seminarMainCourseId);
                int teacherId=seminarMainCourse.getTeacherId();
                if(teacherId!=0){
                teacherList1.add(teacherService.getTeacherByTeacherID(seminarMainCourse.getTeacherId()));
                }
            }
        }

        if (teamMainCourseId!=0)
        {
            if(teamMainCourseId==courseid)
            {
                teamCourseList=courseService.getCourseByTeamMainCourseID(courseid);
                List<Integer> teacherIds=teamCourseList.stream().map(Course::getTeacherId).collect(Collectors.toList());
                if(!teacherIds.isEmpty())
                {
                    teacherList2.addAll(teacherService.getTeachersByTeacherID(teacherIds));
                }
            }
            else
            {
                teamMainCourse=courseService.getCourseByCourseID(teamMainCourseId);
                int teacherId=teamMainCourse.getTeacherId();
                if(teacherId!=0) {
                    teacherList2.add(teacherService.getTeacherByTeacherID(teamMainCourse.getTeacherId()));
                }
            }
        }

        System.out.print(seminarCourseList);
        System.out.print(teamCourseList);
        model.addAttribute("seminarCourseList",seminarCourseList);
        model.addAttribute("seminarMainCourse",seminarMainCourse);
        model.addAttribute("teamCourseList",teamCourseList);
        model.addAttribute("teamMainCourse",teamMainCourse);
        model.addAttribute("teacherList1",teacherList1);
        model.addAttribute("teacherList2",teacherList2);
        model.addAttribute(course);
        model.addAttribute("id",tid);
        return "/teacher/course/shareList";
    }

}
