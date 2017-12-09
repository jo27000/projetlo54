/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jonathan
 */
public class CourseSessionDaoImpl implements CourseSessionService {

    private Session session;

    @Override
    public Integer create(CourseSession newInstance) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(newInstance);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public CourseSession read(Integer id) {

        session = HibernateUtil.getSessionFactory().openSession();

        CourseSession cs = (CourseSession) session.get(CourseSession.class, id);
        session.close();
        return cs;
    }

    @Override
    public void update(CourseSession transientObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(transientObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(CourseSession persistentObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(persistentObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CourseSession getByStartDate(Calendar startDate) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseSession getByEndDate(Calendar endDate) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseSession getByCourseCode(String courseCode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseSession getByLocationId(Integer locationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseSession> getAll(int index, int size, String sortField, String sortOrder) {
        session = HibernateUtil.getSessionFactory().openSession();

        Query selectQuery = session.createQuery("From CourseSession");
        selectQuery.setFirstResult(index);
        selectQuery.setMaxResults(size);
        List<CourseSession> courseList = selectQuery.list();
        session.close();

        return courseList;
    }

    @Override
    public int getCount() {

        session = HibernateUtil.getSessionFactory().openSession();
        Integer rowCount = (Integer) session.createCriteria("com.utbm.lo54.projetlo54.entity.CourseSession").setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return rowCount;
    }

    @Override
    public int getCount(Map<String, Object> filters) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria("com.utbm.lo54.projetlo54.entity.CourseSession");
        if (filters != null && !filters.isEmpty()) {
            for (Map.Entry entry : filters.entrySet()) {
                if (entry.getKey().toString().contains("city")) {
                    crit.createAlias("location", "location");
                    crit.add(Restrictions.eq("location.city", entry.getValue().toString()));
                }
                if (entry.getKey().toString().contains("title")) {
                    crit.createAlias("course", "course");
                    crit.add(Restrictions.ilike("course.title", entry.getValue().toString(), MatchMode.ANYWHERE));
                }
                if (entry.getKey().toString().equals("startDate")) {
                    crit.add(Restrictions.ge("startDate", entry.getValue()));
                }
            }
        }
        crit.setProjection(Projections.rowCount());
        Integer rowCount = (Integer) crit.uniqueResult();
        session.close();
        return rowCount;
    }

    @Override
    public List<CourseSession> getAll(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria("com.utbm.lo54.projetlo54.entity.CourseSession");
        crit.createAlias("location", "location");
        crit.createAlias("course", "course");
        if (filters != null && !filters.isEmpty()) {
            for (Map.Entry entry : filters.entrySet()) {
                if (entry.getKey().toString().contains("city")) {
                    crit.add(Restrictions.eq("location.city", entry.getValue().toString()));
                }
                if (entry.getKey().toString().contains("title")) {
                    crit.add(Restrictions.ilike("course.title", entry.getValue().toString(), MatchMode.ANYWHERE));
                }
                if (entry.getKey().toString().equals("startDate")) {
                    crit.add(Restrictions.ge("startDate", entry.getValue()));
                }
            }

        }
        if (sortField != null && !sortField.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {

            if (sortOrder.equals("ASCENDING")) {
                crit.addOrder(Order.asc(sortField));
            } else {
                crit.addOrder(Order.desc(sortField));
            }
        }

        crit.setFirstResult(first);
        crit.setMaxResults(pageSize);
        List<CourseSession> courseList = crit.list();
        session.close();

        return courseList;
    }

}
