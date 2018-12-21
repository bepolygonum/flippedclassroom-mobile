package com.entity;

public class Team {
    private int id;
    private int klass_id;
    private int course_id;
    private int leader_id;
    private String team_name;
    private int team_serial;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlass_id() {
        return klass_id;
    }

    public void setKlass_id(int klass_id) {
        this.klass_id = klass_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getTeam_serial() {
        return team_serial;
    }

    public void setTeam_serial(int team_serial) {
        this.team_serial = team_serial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
