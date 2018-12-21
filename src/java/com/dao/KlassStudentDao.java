package com.dao;

import com.entity.KlassStudent;

import java.util.List;

public interface KlassStudentDao {
    List<KlassStudent> getKlassStudentByCourseID(int courseId);
}
