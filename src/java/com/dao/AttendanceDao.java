package com.dao;

import com.entity.Attendance;

import java.util.List;

/**
 * @author KEKE
 */
public interface AttendanceDao {
    /**
     * insert Attend By Team Id And SeminarId
     * @param teamid
     * @param seminarid
     * @param order
     */
    void insertAttendByTeamIdAndSeminarId(int teamid, int seminarid,int order);

    /**
     * getAttendanceByKlassSeminarId
     * @param klassSeminarId
     * @return
     */
    List<Attendance> getAttendanceByKlassSeminarId(int klassSeminarId);
}
