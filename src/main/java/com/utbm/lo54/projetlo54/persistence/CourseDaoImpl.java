/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.Course;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseService;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Jonathan
 */
public class CourseDaoImpl implements CourseService {

    private Session session;

    @Override
    public Integer create(Course newInstance) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(newInstance);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Course read(Integer id) {

        session = HibernateUtil.getSessionFactory().openSession();
        Course c = (Course) session.get(Course.class, id);
        session.close();
        return c;
    }

    @Override
    public void update(Course transientObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(transientObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Course persistentObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(persistentObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Course getByTitle(String title) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> getAll(int index, int size, String sortField, String sortOrder) {
        session = HibernateUtil.getSessionFactory().openSession();

        Query selectQuery = session.createQuery("From Course");
        selectQuery.setFirstResult(index);
        selectQuery.setMaxResults(size);
        List<Course> courseList = selectQuery.list();
        session.close();

        return courseList;
    }

    @Override
    public int getCount() {
        session = HibernateUtil.getSessionFactory().openSession();
        Integer rowCount = (Integer) session.createCriteria("com.utbm.lo54.projetlo54.entity.Course").setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return rowCount;
    }

    @Override
    public List<Course> getAllByTitleKeyWords(int index, int size, String sortField, String sortOrder, Map<String, Object> filters) {
        session = HibernateUtil.getSessionFactory().openSession();

        Query selectQuery = session.createQuery("From Course");

        selectQuery.setFirstResult(index);
        selectQuery.setMaxResults(size);
        List<Course> courseList = selectQuery.list();
        session.close();

        return courseList;
    }

}
