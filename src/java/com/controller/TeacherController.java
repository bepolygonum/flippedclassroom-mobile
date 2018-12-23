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
//某课程下所有学生的id
        List<Integer> studentIds=klassStudentList.stream().map(KlassStudent::getStudent_id).collect(Collectors.toList());
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
    public String CreateCourse(Model model,@RequestParam String id)
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
        int course_id=Integer.parseInt(courseId);
        List<Klass> klassList=klassService.getKlassByCourseID(course_id);
        model.addAttribute(klassList);
        model.addAttribute("courseId",course_id);
        model.addAttribute("id",tid);
        return "/teacher/course/klassList";
    }

    @RequestMapping(value = "/course/klass/create")
    public String CreateKlass(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int course_id=Integer.parseInt(courseId);
        model.addAttribute("courseId",course_id);
        model.addAttribute("id",tid);
        return "/teacher/course/klass/create";

    }

    @RequestMapping(value = "/course/seminar")
    public String findAllSeminar(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int course_id=Integer.parseInt(courseId);
        Course course=courseService.getCourseByCourseID(course_id);
        List<Round> roundList=roundService.getRoundByCourseID(course_id);
        List<Seminar> seminarList=seminarService.getSeminarByCourseID(course_id);
        List<Klass> klassList=klassService.getKlassByCourseID(course_id);

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
        int course_id=Integer.parseInt(courseId);
        List<Teacher> teacherList1=new ArrayList<>();
        List<Teacher> teacherList2=new ArrayList<>();
        Course course=courseService.getCourseByCourseID(course_id);
        //course为主课程
        int seminarMainCourseId=course.getSeminarMainCourseId();
        int teamMainCourseId=course.getTeamMainCourseId();
        List<Course> seminarCourseList=new ArrayList<>();
        Course seminarMainCourse=new Course();
        List<Course> teamCourseList=new ArrayList<>();
        Course teamMainCourse=new Course();
        if (seminarMainCourseId!=0)
        {
            if(seminarMainCourseId==course_id)
            {
                seminarCourseList=courseService.getCourseBySeminarMainCourseID(course_id);
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
            if(teamMainCourseId==course_id)
            {
                teamCourseList=courseService.getCourseByTeamMainCourseID(course_id);
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

        //System.out.print(teacherList);

        //使用hashset去重复，set为重复的集合，可以通过new ArrayList(set)转换成list
        //HashSet<Teacher> set = new HashSet<>();
       // for (Teacher teacher : teacherList) {
          //  set.add(teacher);
        //}
       // List<Teacher> teachers=new ArrayList<>(set);
        //for(Teacher teacher:teacherList)
        //{
          //  if(!teachers.contains(teacher))
            //    teachers.add(teacher);
        //}


        System.out.print(seminarCourseList);
        System.out.print(teamCourseList);
       // System.out.print(teachers);
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
