package com.dao;

import com.entity.SeminarScore;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface SeminarScoreDao {
    /**
     * get SeminarScore By KlassSeminarID
     * @param klassSeminarIds
     * @return
     */
    List<SeminarScore> getSeminarScoreByKlassSeminarID(List<Integer> klassSeminarIds);

    /**
     * insert Enroll By TeamId And SeminarId
     * @param teamid
     * @param seminarid
     */
    void insertEnrollByTeamIdAndSeminarId(int teamid, int seminarid);

}
