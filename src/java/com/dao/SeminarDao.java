package com.dao;

import com.entity.Attendance;
import com.entity.Seminar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface SeminarDao {
    /**
     * get Seminar By RoundID
     * @param roundIds
     * @param courseId
     * @return
     */
    List<Seminar> getSeminarByRoundID(@Param("roundIds") List<Integer> roundIds ,@Param("courseId") int courseId);

    /**
     * get Seminar By CourseID
     * @param courseid
     * @return
     */
    List<Seminar> getSeminarByCourseID(int courseid);

    /**
     * getSeminarBySeminarID
     * @param seminarid
     * @return
     */
    Seminar getSeminarBySeminarID(int seminarid);


    /**
     * getSeminarBySeminarName
     * @param seminarName
     * @return
     */
    Seminar getSeminarBySeminarName(String seminarName);

    /**
     * createASeminar
     * @param courseId
     * @param roundId
     * @param seminarName
     * @param introduction
     * @param maxTeam
     * @param isVisible
     * @param seminarSerial
     * @param startTime
     * @param endTime
     */
    void createASeminar(int courseId, int roundId, String seminarName, String introduction,
                        int maxTeam, int isVisible, int seminarSerial, Timestamp startTime, Timestamp endTime);

}
