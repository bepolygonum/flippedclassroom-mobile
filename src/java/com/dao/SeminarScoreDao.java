package com.dao;

import com.entity.SeminarScore;

import java.util.List;

public interface SeminarScoreDao {
    List<SeminarScore> getSeminarScoreByKlassSeminarID(List<Integer> klassSeminarIds);
}
