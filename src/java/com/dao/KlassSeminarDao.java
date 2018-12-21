package com.dao;

import com.entity.KlassSeminar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KlassSeminarDao {
    List<Integer> getKlassSeminarIDByKlassIdSeminarID(@Param("klassIds")List<Integer> klassIds,@Param("seminarIds") List<Integer> seminarIds);
    List<KlassSeminar> getKlassSeminarByKlassIdSeminarID(@Param("klassIds")List<Integer> klassIds,@Param("seminarIds") List<Integer> seminarIds);
}
