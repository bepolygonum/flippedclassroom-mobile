package com.dao;

import com.entity.KlassSeminar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface KlassSeminarDao {
    List<Integer> getKlassSeminarIDByKlassIdSeminarID(@Param("klassIds")List<Integer> klassIds,@Param("seminarIds") List<Integer> seminarIds);
    List<KlassSeminar> getKlassSeminarByKlassIdSeminarID(@Param("klassIds")List<Integer> klassIds,@Param("seminarIds") List<Integer> seminarIds);
    List getKlassSeminarIDByKlassId(int klassId);
    List<KlassSeminar> getKlassSeminarBySeminarID(List<Integer> seminarIds);
}
