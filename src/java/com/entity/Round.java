package com.entity;

/**
 * @author KEKE
 */
public class Round {
    private int id;
    private int courseId;
    private int roundSerial;
    private int presentationScoreMethod;
    private int reportScoreMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getRoundSerial() {
        return roundSerial;
    }

    public void setRoundSerial(int roundSerial) {
        this.roundSerial = roundSerial;
    }

    public int getPresentationScoreMethod() {
        return presentationScoreMethod;
    }

    public void setPresentationScoreMethod(int presentationScoreMethod) {
        this.presentationScoreMethod = presentationScoreMethod;
    }

    public int getReportScoreMethod() {
        return reportScoreMethod;
    }

    public void setReportScoreMethod(int reportScoreMethod) {
        this.reportScoreMethod = reportScoreMethod;
    }

    public int getQuestionScoreMethod() {
        return questionScoreMethod;
    }

    public void setQuestionScoreMethod(int questionScoreMethod) {
        this.questionScoreMethod = questionScoreMethod;
    }

    private int questionScoreMethod;

}
