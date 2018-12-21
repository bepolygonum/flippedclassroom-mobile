package com.service;

import com.entity.KlassSeminar;
import com.entity.SeminarScore;

import java.util.List;

public interface KlassService {
    List<SeminarScore> getSeminarScoreByCourseSeminarID(int courseId, List<Integer> seminarIds);
    List<KlassSeminar> getKlassSeminarByCourseSeminarID(int courseId, List<Integer> seminarIds);
}
