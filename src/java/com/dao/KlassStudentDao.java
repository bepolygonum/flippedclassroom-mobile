package com.dao;

import com.entity.KlassStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KEKE
 */
@Repository
public interface KlassStudentDao {
    /**
     * get KlassStudent By CourseID
     * @param courseId
     * @return
     */
    List<KlassStudent> getKlassStudentByCourseID(int courseId);

    /**
     * get KlassStudent By StudentId And KlassId
     * @param studentId
     * @param klassid
     * @return
     */
    List<KlassStudent> getKlassStudentByStudentIdAndKlassId(int studentId,int klassid);


}
