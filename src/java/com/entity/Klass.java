package com.entity;

public class Klass {
    private int id;
    private int course_id;
    private int grade;
    private int klass_serial;
    private String klass_time;
    private String klass_location;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getKlass_serial() {
        return klass_serial;
    }

    public void setKlass_serial(int klass_serial) {
        this.klass_serial = klass_serial;
    }

    public String getKlass_time() {
        return klass_time;
    }

    public void setKlass_time(String klass_time) {
        this.klass_time = klass_time;
    }

    public String getKlass_location() {
        return klass_location;
    }

    public void setKlass_location(String klass_location) {
        this.klass_location = klass_location;
    }
}