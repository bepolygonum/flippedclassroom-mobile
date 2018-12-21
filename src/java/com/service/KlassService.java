package com.service;

import com.entity.Klass;
import com.entity.KlassSeminar;
import com.entity.KlassStudent;
import com.entity.SeminarScore;

import java.util.List;

public interface KlassService {
    List<SeminarScore> getSeminarScoreByCourseSeminarID(int courseId, List<Integer> seminarIds);
    List<KlassSeminar> getKlassSeminarByCourseSeminarID(int courseId, List<Integer> seminarIds);
    List <Klass> getKlassByStudentID(int id);
    List<KlassStudent> getKlassStudentByCourseID(int courseId);
    List<Klass> getKlassByCourseID(int courseId);
}
