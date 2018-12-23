package com.entity;

/**
 * @author KEKE
 */
public class RoundScore {
    private int round_id;
    private int team_id;
    private double total_score;
    private double presentation_score;
    private double question_score;
    private double report_score;

    public double getQuestion_score() {
        return question_score;
    }

    public void setQuestion_score(double question_score) {
        this.question_score = question_score;
    }

    public int getRound_id() {
        return round_id;
    }

    public void setRound_id(int round_id) {
        this.round_id = round_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public double getPresentation_score() {
        return presentation_score;
    }

    public void setPresentation_score(double presentation_score) {
        this.presentation_score = presentation_score;
    }

    public double getReport_score() {
        return report_score;
    }

    public void setReport_score(double report_score) {
        this.report_score = report_score;
    }
}
