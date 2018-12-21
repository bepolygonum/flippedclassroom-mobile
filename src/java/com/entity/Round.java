package com.entity;

public class Round {
    private int id;
    private int course_id;
    private int round_serial;
    private int presentation_score_method;
    private int report_score_method;
    private int question_score_method;

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

    public int getRound_serial() {
        return round_serial;
    }

    public void setRound_serial(int round_serial) {
        this.round_serial = round_serial;
    }

    public int getPresentation_score_method() {
        return presentation_score_method;
    }

    public void setPresentation_score_method(int presentation_score_method) {
        this.presentation_score_method = presentation_score_method;
    }

    public int getReport_score_method() {
        return report_score_method;
    }

    public void setReport_score_method(int report_score_method) {
        this.report_score_method = report_score_method;
    }

    public int getQuestion_score_method() {
        return question_score_method;
    }

    public void setQuestion_score_method(int question_score_method) {
        this.question_score_method = question_score_method;
    }
}
