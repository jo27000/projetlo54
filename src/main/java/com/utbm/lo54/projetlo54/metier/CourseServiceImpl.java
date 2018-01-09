/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier;

import com.utbm.lo54.projetlo54.entity.Course;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseService;
import com.utbm.lo54.projetlo54.persistence.CourseDaoImpl;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jonathan
 */
public class CourseServiceImpl implements CourseService {

    private CourseService courseDao = new CourseDaoImpl();

    @Override
    public Integer create(Course newInstance) {
        return courseDao.create(newInstance);
    }

    @Override
    public Course read(Integer id) {
        return courseDao.read(id);
    }

    @Override
    public void update(Course transientObject) {
        courseDao.update(transientObject);
    }

    @Override
    public void delete(Course persistentObject) {
        courseDao.delete(persistentObject);
    }

    @Override
    public Course getByTitle(String title) throws Exception {
        return courseDao.getByTitle(title);
    }

    @Override
    public List<Course> getAll(int index, int size, String sortField, String sortOrder) {
        return courseDao.getAll(index, size, sortField, sortOrder);
    }

    @Override
    public int getCount() {
        return courseDao.getCount();
    }

    @Override
    public List<Course> getAllByTitleKeyWords(int index, int size, String sortField, String sortOrder, Map<String, Object> filters) {
        return courseDao.getAllByTitleKeyWords(index, size, sortField, sortOrder, filters);
    }

    @Override
    public String getByIdWithRedis(Integer id) {
        return courseDao.getByIdWithRedis(id);

    }

    @Override
    public Set<String> getIdSetWithRedis() {
        return courseDao.getIdSetWithRedis();
    }
}
