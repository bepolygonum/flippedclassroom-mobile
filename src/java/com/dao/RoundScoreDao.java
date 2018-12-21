package com.dao;

import com.entity.RoundScore;

import java.util.List;

public interface RoundScoreDao {
    List<RoundScore> getRoundScoreByRoundID(List<Integer> roundIds);
}
