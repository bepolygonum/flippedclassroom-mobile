package com.dao;

import com.entity.Klass;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface KlassDao {
    /**
     * get KlassID By CourseID
     * @param courseId
     * @return
     */
    List<Integer> getKlassIDByCourseID(int courseId);

    /**
     *  get KlassID By StudentID
     * @param id
     * @return
     */
    List getKlassIDByStudentID(int id);

    /**
     * get Klass By KlassID
     * @param id
     * @return
     */
    Klass getKlassByKlassID(int id);

    /**
     *  get Klass By CourseID
     * @param courseId
     * @return
     */
    List<Klass> getKlassByCourseID(int courseId);

    void createAKlass(int courseId,int grade,int klassSerial,String klassTime,String location);
}
