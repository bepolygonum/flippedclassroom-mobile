package com.service;

import com.entity.Seminar;
import com.entity.SeminarScore;

import java.util.List;

public interface SeminarService {
    List<Seminar> getSeminarByCourseID(int courseId);

    List<SeminarScore> getSeminarScoreByTeamIdAndKlassId(int team_id, int klassId);
}
