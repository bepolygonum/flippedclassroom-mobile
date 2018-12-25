package com.dao;

import com.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author KEKE
 */
@Repository
public interface TeamDao {
    /**
     * get Team By CourseID
     * @param courseId
     * @return
     */
    List<Team> getTeamByCourseID(int courseId);

    /**
     * get Team By Id
     * @param teamid
     * @return
     */
    Team getTeamById(int teamid);

    /**
     * getTeamIdById
     * @param id
     * @return
     */
    List getTeamIdByStudentId(int id);

    /**
     * getStudentByTeamID
     * @param id
     * @return
     */
    List getStudentIdByTeamId(int id);

    /**
     * getTeamByKlassID
     * @param ids
     * @return
     */
    List<Integer> getTeamIdByKlassId(List<Integer> ids);

    List<Team> getTeamByIds(List<Integer> ids);
}
