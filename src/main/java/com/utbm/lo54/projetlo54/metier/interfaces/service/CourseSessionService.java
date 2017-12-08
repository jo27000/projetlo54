/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.CourseSession;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public interface CourseSessionService extends GenericService<CourseSession, Integer> {

    CourseSession getByStartDate(Calendar startDate) throws Exception;

    CourseSession getByEndDate(Calendar endDate) throws Exception;

    CourseSession getByCourseCode(String courseCode) throws Exception;

    CourseSession getByLocationId(Integer locationId) throws Exception;

    List<CourseSession> getAll(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
}
