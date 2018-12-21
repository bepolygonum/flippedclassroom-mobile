package com.dao;

import java.util.List;

public interface KlassDao {
    List<Integer> getKlassIDByCourseID(int courseId);
}
