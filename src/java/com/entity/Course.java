package com.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Course {
    private int id;
    private int teacher_id;
    private String course_name;
    private String introduction;
    private int presentation_percentage;
    private int question_percentage;
    private int report_percentage;
    private int team_main_course_id;
    private int seminar_main_course_id;


    private Date startTime;
    private String team_start_time;
    private SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Date endTime;
    private String team_end_time;
    private SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPresentation_percentage() {
        return presentation_percentage;
    }

    public void setPresentation_percentage(int presentation_percentage) {
        this.presentation_percentage = presentation_percentage;
    }

    public int getQuestion_percentage() {
        return question_percentage;
    }

    public void setQuestion_percentage(int question_percentage) {
        this.question_percentage = question_percentage;
    }

    public int getReport_percentage() {
        return report_percentage;
    }

    public void setReport_percentage(int report_percentage) {
        this.report_percentage = report_percentage;
    }

    public int getTeam_main_course_id() {
        return team_main_course_id;
    }

    public void setTeam_main_course_id(int team_main_course_id) {
        this.team_main_course_id = team_main_course_id;
    }

    public int getSeminar_main_course_id() {
        return seminar_main_course_id;
    }

    public void setSeminar_main_course_id(int seminar_main_course_id) {
        this.seminar_main_course_id = seminar_main_course_id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
        String time = startSdf.format(startTime);
        setTeam_start_time(time);
    }

    public String getTeam_start_time() {
        return team_start_time;
    }

    public void setTeam_start_time(String team_start_time) {
        this.team_start_time = team_start_time;
    }

    public SimpleDateFormat getStartSdf() {
        return startSdf;
    }

    public void setStartSdf(SimpleDateFormat startSdf) {
        this.startSdf = startSdf;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
        String time = endSdf.format(endTime);
        setTeam_end_time(time);
    }
    public String getTeam_end_time() {
        return team_end_time;
    }

    public void setTeam_end_time(String team_end_time) {
        this.team_end_time = team_end_time;
    }

    public SimpleDateFormat getEndSdf() {
        return endSdf;
    }

    public void setEndSdf(SimpleDateFormat endSdf) {
        this.endSdf = endSdf;
    }


}
