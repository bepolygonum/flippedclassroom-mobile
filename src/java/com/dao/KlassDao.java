package com.dao;

import com.entity.Klass;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KlassDao {
    List<Integer> getKlassIDByCourseID(int courseId);
    List getKlassIDByStudentID(int id);
    Klass getKlassByKlassID(int id);
    List<Klass> getKlassByCourseID(int courseId);
}
