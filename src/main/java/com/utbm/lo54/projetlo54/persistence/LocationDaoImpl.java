/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.Location;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import org.hibernate.Session;

/**
 *
 * @author Jonathan
 */
public class LocationDaoImpl implements LocationService {

    private Session session;

    @Override
    public Integer create(Location newInstance) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(newInstance);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Location read(Integer id) {

        session = HibernateUtil.getSessionFactory().openSession();
        Location l = (Location) session.get(Location.class, id);
        session.close();
        return l;
    }

    @Override
    public void update(Location transientObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(transientObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Location persistentObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(persistentObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Location getByCity(String city) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
