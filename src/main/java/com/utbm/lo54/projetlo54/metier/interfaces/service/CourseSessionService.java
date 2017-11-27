/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.CourseSession;
import java.util.Calendar;

/**
 *
 * @author Jonathan
 */
public interface CourseSessionService extends GenericService<CourseSession, Integer> {

    public CourseSession getByStartDate(Calendar startDate) throws Exception;

    public CourseSession getByEndDate(Calendar endDate) throws Exception;

    public CourseSession getByCourseCode(String courseCode) throws Exception;

    public CourseSession getByLocationId(Integer locationId) throws Exception;

}
