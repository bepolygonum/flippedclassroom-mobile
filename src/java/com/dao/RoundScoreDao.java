package com.dao;

import com.entity.RoundScore;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface RoundScoreDao {
    /**
     * get RoundScore By RoundID
     * @param roundIds
     * @return
     */
    List<RoundScore> getRoundScoreByRoundID(List<Integer> roundIds);
}
