/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier;

import com.utbm.lo54.projetlo54.entity.Course;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseService;
import com.utbm.lo54.projetlo54.persistence.CourseDaoImpl;

/**
 *
 * @author Jonathan
 */
public class CourseServiceImpl implements CourseService {

    private CourseService clientDao = new CourseDaoImpl();

    @Override
    public Integer create(Course newInstance) {
        return clientDao.create(newInstance);
    }

    @Override
    public Course read(Integer id) {
        return clientDao.read(id);
    }

    @Override
    public void update(Course transientObject) {
        clientDao.update(transientObject);
    }

    @Override
    public void delete(Course persistentObject) {
        clientDao.delete(persistentObject);
    }

    @Override
    public Course getByTitle(String title) throws Exception {
        return clientDao.getByTitle(title);
    }

}
