/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier;

import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import com.utbm.lo54.projetlo54.persistence.CourseSessionDaoImpl;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class CourseSessionServiceImpl implements CourseSessionService {

    private CourseSessionService courseSessionDao = new CourseSessionDaoImpl();

    @Override
    public Integer create(CourseSession newInstance) {
        return courseSessionDao.create(newInstance);
    }

    @Override
    public CourseSession read(Integer id) {
        return courseSessionDao.read(id);
    }

    @Override
    public void update(CourseSession transientObject) {
        courseSessionDao.update(transientObject);
    }

    @Override
    public void delete(CourseSession persistentObject) {
        courseSessionDao.delete(persistentObject);
    }

    @Override
    public CourseSession getByStartDate(Calendar startDate) throws Exception {
        return courseSessionDao.getByStartDate(startDate);
    }

    @Override
    public CourseSession getByEndDate(Calendar endDate) throws Exception {
        return courseSessionDao.getByEndDate(endDate);
    }

    @Override
    public CourseSession getByCourseCode(String courseCode) throws Exception {
        return courseSessionDao.getByCourseCode(courseCode);
    }

    @Override
    public CourseSession getByLocationId(Integer locationId) throws Exception {
        return courseSessionDao.getByLocationId(locationId);
    }

    @Override
    public List<CourseSession> getAll(int index, int size, String sortField, String sortOrder) {
        return courseSessionDao.getAll(index, size, sortField, sortOrder);
    }

    @Override
    public int getCount() {
        return courseSessionDao.getCount();
    }

}
