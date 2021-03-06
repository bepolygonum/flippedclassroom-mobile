package com.controller;

import com.dao.TeamDao;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String teacherHome(Model model,@RequestParam String id)
    {
        int tid=Integer.parseInt(id);
        Teacher teacher=teacherService.getTeacherByTeacherID(tid);
        model.addAttribute(teacher);
        return "teacher/home";
    }


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

        List<Round> roundList=roundService.getRoundByCourseID(courseid);
        List<RoundScore> roundScoreList=roundService.getRoundScoreByCourseID(courseid);

        //所有rounds的id集合
        List<Integer> roundIds=roundList.stream().map(Round::getId).collect(Collectors.toList());

        List<Seminar> seminarList=roundService.getSeminarByRoundID(roundIds,courseid);
        //某课程下所有seminar的id
        List<Integer> seminarIds=seminarList.stream().map(Seminar::getId).collect(Collectors.toList());
        List<SeminarScore> seminarScoreList=klassService.getSeminarScoreByCourseSeminarID(courseid,seminarIds);
        List<KlassSeminar> klassSeminarList=klassService.getKlassSeminarByCourseSeminarID(courseid,seminarIds);

        List<Team> teamList=teamService.getTeamByCourseID(courseid);

        List<Klass> klassList=klassService.getKlassByCourseID(courseid);

        //new
        model.addAttribute(roundList);

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

        List<Team> teamList=teamService.getTeamByCourseID(courseid);

        List<Integer> teamIds=teamList.stream().map(Team::getId).collect(Collectors.toList());
        List<TeamStudent> teamStudentList=teamService.getTeamStudentsByTeamIds(teamIds);

        List<Integer> studentIds=teamStudentList.stream().map(TeamStudent::getStudentId).collect(Collectors.toList());
        List<Student> studentList=studentService.getStudentByStudentID(studentIds);

        List<Klass> klassList=klassService.getKlassByCourseID(courseid);


    /*    List<Integer> teamLeaderIds=teamList.stream().map(Team::getLeaderId).collect(Collectors.toList());
        List<Student> leaderStudent=new ArrayList<>();
        List<Student> normalStudent=new ArrayList<>();
       for(int i=0;i<studentList.size();i++)
        {
            for(int j=0;j<teamLeaderIds.size();j++)
            {
                if(studentList.get(i).getId()==teamLeaderIds.get(j))
                {
                    leaderStudent.add(studentList.get(i));
                }
                else
                {
                    normalStudent.add(studentList.get(i));
                }
            }
        }
        studentList.clear();
        studentList.addAll(leaderStudent);
        studentList.addAll(normalStudent);*/

        model.addAttribute(teamList);
        model.addAttribute(teamStudentList);
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
        System.out.print(courseid);

        int conflictId=courseService.getConflictIdByCourseID(courseid);
        if(conflictId!=0)
        {
            List<Integer> courseIds=courseService.getConflictCourseIdByID(conflictId);
            List<Course> courseList=courseService.getCoursesByCourseID(courseIds);
            List<Integer> teacherIds=courseList.stream().map(Course::getTeacherId).collect(Collectors.toList());
            List<Teacher> teacherList=teacherService.getTeachersByTeacherID(teacherIds);
            model.addAttribute(courseList);
            model.addAttribute(teacherList);
        }

        //List<Course> courseList=courseService.getConflictCourseByCourseID(courseid);
        //System.out.print(courseList);
        Course course=courseService.getCourseByCourseID(courseid);
        System.out.print(course);
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseService.getCourseMemberLimitByCourseID(courseid);

        //  List<Integer> teacherIds=courseList.stream().map(Course::getTeacherId).collect(Collectors.toList());
        // List<Teacher> teacherList=teacherService.getTeachersByTeacherID(teacherIds);
      /*  if(!courseList.isEmpty())
        {
            model.addAttribute(courseList);
            model.addAttribute(teacherList);
        }*/
        if(courseMemberLimitStrategy!=null)
        {
            model.addAttribute(courseMemberLimitStrategy);
        }
        System.out.print(courseMemberLimitStrategy);
        model.addAttribute(course);
        model.addAttribute("id",tid);
        return "/teacher/course/info";
    }

    @RequestMapping(value = "/course/createCourse")
    public String createCourse(Model model,@RequestParam String id)
    {
        int tid=Integer.parseInt(id);
        List<Course> courseList=courseService.getAllCourses();
        List<Teacher> teacherList=teacherService.getAllTeachers();
        model.addAttribute("id",tid);
        model.addAttribute(courseList);
        model.addAttribute(teacherList);
        return "/teacher/course/createCourse";
    }


    @RequestMapping(value = "/course/createCourse",method = RequestMethod.POST)
    public String CreateACourse(Model model, @RequestParam String id, @RequestParam String courseName, @RequestParam String courseRequest, @RequestParam String presentation,
                                @RequestParam String question, @RequestParam String report, @RequestParam String max, @RequestParam String min,
                                @RequestParam String startDate, @RequestParam String startTime, @RequestParam String endDate, @RequestParam String endTime,
                                @RequestParam List<String> conflict, HttpServletResponse response) throws IOException//
    {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        int tid=Integer.parseInt(id);
        System.out.print(conflict);
        if(courseService.getCourseByCourseName(courseName)==null)
        {
            int presentationPercentage=Integer.parseInt(presentation);
            int questionPercentage=Integer.parseInt(question);
            int reportPercentage=Integer.parseInt(report);

            String tstartTime=startDate+" "+startTime+":00";
            String tendTime=endDate+" "+endTime+":00";

            System.out.print(startDate);
            System.out.print(startTime);
            System.out.print(endDate);
            System.out.print(endTime);
            Timestamp teamStartTime=Timestamp.valueOf(tstartTime);
            Timestamp teamEndTime=Timestamp.valueOf(tendTime);
            courseService.createACourse(tid,courseName,courseRequest,presentationPercentage,questionPercentage,reportPercentage,teamStartTime,teamEndTime);


            Course course=courseService.getCourseByCourseName(courseName);

            int maxId=0;
            System.out.print(conflict);
            List<Integer> conflictIds=courseService.getAllConflictId();
            for(int i=0;i<conflictIds.size();i++)
            {
                if(conflictIds.get(i)>maxId)
                { maxId=conflictIds.get(i);}
            }

            int cid;
            for(int i=0;i<conflict.size();i++)
            {
                cid=Integer.parseInt(conflict.get(i));
                if(cid!=0)
                {
                    courseService.createConflictCourse(maxId+1,course.getId(),cid);
                }
            }

        }
        else
        {
            out.print("<script>alert('课程名相同，创建失败');history.go(-1);</script>");
        }

        List<Course> courseList=courseService.getCourseByTeacherID(tid);
        model.addAttribute("id",tid);
        model.addAttribute(courseList);
        return "/teacher/courseManage";
    }


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

    @RequestMapping(value = "/course/klass/createKlass")
    public String createKlass(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        model.addAttribute("courseId",courseid);
        model.addAttribute("id",tid);
        return "teacher/course/klass/createKlass";

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

        if(seminarMainCourseId==0)
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
        if(teamMainCourseId==0)
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
        System.out.print(seminarCourseList);
        System.out.print(teamCourseList);
        System.out.print(teacherList1);
        System.out.print(teacherList2);
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

    @RequestMapping(value = "course/seminar/createSeminar")
    public String createSeminarPage(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        int max=0;
        Course course=courseService.getCourseByCourseID(courseid);
        List<Round> roundList=roundService.getRoundByCourseID(courseid);
        for(int i=0;i<roundList.size();i++)
        {
            if(roundList.get(i).getRoundSerial()>max)
            {max=roundList.get(i).getRoundSerial();}
        }
        //排序
        Collections.sort(roundList, new Round());
        //Round entity implement
        //第一个参数为List 第二个参数为对象的一个实例
        List<Seminar> seminarList=seminarService.getSeminarByCourseID(courseid);
        model.addAttribute(course);
        model.addAttribute("id",tid);
        model.addAttribute(roundList);
        model.addAttribute(seminarList);
        return "/teacher/course/seminar/createSeminar";
    }

    @RequestMapping(value = "course/seminar/createSeminar",method = RequestMethod.POST)
    public String CreateASeminar(Model model, @RequestParam String id, @RequestParam String courseId,@RequestParam String seminarName, @RequestParam String mainContent,
                                 @RequestParam String serial, @RequestParam String isVisible, @RequestParam String startDate, @RequestParam String endDate,
                                 @RequestParam String number, @RequestParam String order, @RequestParam String round, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);

        if(seminarService.getSeminarBySeminarName(seminarName)==null)
        {
            int seminarSerial=Integer.parseInt(serial);
            int teamNumber=Integer.parseInt(number);
            int roundId=Integer.parseInt(round);
            int nisVisible,norder;
            if(isVisible.isEmpty())
            {
                nisVisible=0;
            }
            else{nisVisible=1;}

            if(order.isEmpty())
            {
                norder=0;
            }
            else{norder=1;}

            System.out.print(startDate);
            System.out.print(endDate);
            String[] start=startDate.split("T");
            String[] end=endDate.split("T");

            String tstartTime=start[0]+" "+start[1]+":00";
            String tendTime=end[0]+" "+end[1]+":00";

            System.out.print(isVisible);
            System.out.print(order);

            if(roundId==0)
            {
                int max=0;
                List<Round> roundList=roundService.getRoundByCourseID(courseid);
                for(int i=0;i<roundList.size();i++)
                {
                    if(roundList.get(i).getRoundSerial()>max)
                    {max=roundList.get(i).getRoundSerial();}
                }
                roundId=max+1;
            }


            Timestamp teamStartTime=Timestamp.valueOf(tstartTime);
            Timestamp teamEndTime=Timestamp.valueOf(tendTime);
            seminarService.createASeminar(courseid,roundId, seminarName, mainContent,teamNumber, nisVisible, seminarSerial, teamStartTime, teamEndTime);

        }
        else
        {
            out.print("<script>alert('讨论课名相同，创建失败');history.go(-1);</script>");
        }

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
        return "/teacher/course/seminarList";
    }


    @RequestMapping(value = "/course/createShare")
    public String createShare(Model model,@RequestParam String id,@RequestParam String courseId)
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        List<Course> courseList=courseService.getAllCourses();
        List<Teacher> teacherList=teacherService.getAllTeachers();
        model.addAttribute("courseId",courseid);
        model.addAttribute("id",tid);
        model.addAttribute(courseList);
        model.addAttribute(teacherList);
        return "teacher/course/createShare";
    }

    @RequestMapping(value = "/course/seminar/createKlass",method = RequestMethod.POST)
    public String CreateAKlass(Model model, @RequestParam String id, @RequestParam String courseId,@RequestParam int grade, @RequestParam int klass,
                               @RequestParam String firstCourse, @RequestParam String secondCourse, @RequestParam String location, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);
        int second=Integer.parseInt(secondCourse);
        String time;
        if(klassService.getKlassByKlassID(klass)==null)
        {
            if(second<=4)
            {
                time="上午"+firstCourse+","+secondCourse+"节";
            }
            else if(second<=8)
            {
                time="下午"+firstCourse+","+secondCourse+"节";
            }
            else
            {
                time="晚上"+firstCourse+","+secondCourse+"节";
            }
            klassService.createAKlass(courseid,grade,klass,time,location);
        }
        else
        {
            out.print("<script>alert('班级名相同，创建失败');history.go(-1);</script>");
        }

        List<Klass> klassList=klassService.getKlassByCourseID(courseid);
        model.addAttribute(klassList);
        model.addAttribute("courseId",courseid);
        model.addAttribute("id",tid);
        return "/teacher/course/klassList";
    }

/*    @RequestMapping(value = "/course/createShare",method = RequestMethod.POST)
    public String createAShare(Model model,@RequestParam String id,@RequestParam String courseId,@RequestParam int shareType,
                               @RequestParam int shareCourse,HttpServletResponse response) throws IOException
    {
        int tid=Integer.parseInt(id);
        int courseid=Integer.parseInt(courseId);

        courseService
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

        if(seminarMainCourseId==0)
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
        if(teamMainCourseId==0)
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
        System.out.print(seminarCourseList);
        System.out.print(teamCourseList);
        System.out.print(teacherList1);
        System.out.print(teacherList2);
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
*/

}
