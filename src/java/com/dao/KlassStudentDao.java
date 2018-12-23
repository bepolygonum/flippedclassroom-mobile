package com.dao;

import com.entity.KlassStudent;

import java.util.List;

public interface KlassStudentDao {
    List<KlassStudent> getKlassStudentByCourseID(int courseId);
    List<KlassStudent> getKlassStudentByStudentIdAndKlassId(int studentId,int klassid);
    List<KlassStudent> getKlassStudentByTeamID(int team_id, int courseId);

    List<KlassStudent> getKlassStudentWithNoTeam(int courseId);
}
