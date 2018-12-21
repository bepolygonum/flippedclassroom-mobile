package com.entity;

public class CourseMemberLimitStrategy {
    private int id;
    private int course_id;
    private int min_member;

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

    public int getMin_member() {
        return min_member;
    }

    public void setMin_member(int min_member) {
        this.min_member = min_member;
    }

    public int getMax_member() {
        return max_member;
    }

    public void setMax_member(int max_member) {
        this.max_member = max_member;
    }

    private int max_member;
}
