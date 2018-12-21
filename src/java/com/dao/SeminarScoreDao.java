package com.dao;

import com.entity.SeminarScore;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeminarScoreDao {
    List<SeminarScore> getSeminarScoreByKlassSeminarID(List<Integer> klassSeminarIds);
}
