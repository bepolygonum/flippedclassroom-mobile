package com.entity;

import java.sql.Timestamp;

public class Course {
    private int id;
    private int teacher_id;
    private String course_name;
    private String introduction;
    private int presentation_percentage;
    private int question_percentage;
    private int report_percentage;

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

    public Timestamp getTeam_start_time() {
        return team_start_time;
    }

    public void setTeam_start_time(Timestamp team_start_time) {
        this.team_start_time = team_start_time;
    }

    public Timestamp getTeam_end_time() {
        return team_end_time;
    }

    public void setTeam_end_time(Timestamp team_end_time) {
        this.team_end_time = team_end_time;
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

    private Timestamp team_start_time;
    private Timestamp team_end_time;
    private int team_main_course_id;
    private int seminar_main_course_id;

}
