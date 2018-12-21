package com.service;

import com.entity.RoundScore;
import com.entity.Seminar;

import java.util.List;

public interface RoundService {
    List<RoundScore> getRoundScoreByCourseID(int courseId);
    List<Seminar>  getSeminarByRoundID(List<Integer> roundIds, int courseId);
}
