/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.Course;

/**
 *
 * @author Jonathan
 */
public interface CourseService extends GenericService<Course, Integer> {

    public Course getByTitle(String title) throws Exception;

}
