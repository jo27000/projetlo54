/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public interface CourseService extends GenericService<Course, Integer> {

    Course getByTitle(String title) throws Exception;

    List<Course> getAllByTitleKeyWords(int index, int size, String sortField, String sortOrder, Map<String, Object> filters);

}
