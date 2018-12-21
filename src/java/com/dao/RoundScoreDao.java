package com.dao;

import com.entity.RoundScore;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoundScoreDao {
    List<RoundScore> getRoundScoreByRoundID(List<Integer> roundIds);
}
