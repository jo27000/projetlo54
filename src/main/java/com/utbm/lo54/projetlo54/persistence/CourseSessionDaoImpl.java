/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.CourseSession;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseSessionService;
import java.util.Calendar;
import org.hibernate.Session;

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

}
