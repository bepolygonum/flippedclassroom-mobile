package com.entity;

import java.sql.Timestamp;

public class Seminar {
    private int id;
    private int course_id;
    private int round_id;
    private String seminar_name;
    private String introduction;
    private int max_team;
    private int is_visible;
    private int seminar_serial;
    private Timestamp enroll_start_time;
    private Timestamp enroll_end_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getRound_id() {
        return round_id;
    }

    public void setRound_id(int round_id) {
        this.round_id = round_id;
    }

    public String getSeminar_name() {
        return seminar_name;
    }

    public void setSeminar_name(String seminar_name) {
        this.seminar_name = seminar_name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getMax_team() {
        return max_team;
    }

    public void setMax_team(int max_team) {
        this.max_team = max_team;
    }

    public int getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(int is_visible) {
        this.is_visible = is_visible;
    }

    public int getSeminar_serial() {
        return seminar_serial;
    }

    public void setSeminar_serial(int seminar_serial) {
        this.seminar_serial = seminar_serial;
    }

    public Timestamp getEnroll_start_time() {
        return enroll_start_time;
    }

    public void setEnroll_start_time(Timestamp enroll_start_time) {
        this.enroll_start_time = enroll_start_time;
    }

    public Timestamp getEnroll_end_time() {
        return enroll_end_time;
    }

    public void setEnroll_end_time(Timestamp enroll_end_time) {
        this.enroll_end_time = enroll_end_time;
    }



}
