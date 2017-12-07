/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.Location;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

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

    @Override
    public List<Location> getAll(int index, int size, String sortField, String sortOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {

        session = HibernateUtil.getSessionFactory().openSession();
        Integer rowCount = (Integer) session.createCriteria("com.utbm.lo54.projetlo54.entity.Location").setProjection(Projections.rowCount()).uniqueResult();
        session.close();
        return rowCount;
    }

    @Override
    public List<String> getAllCityNames() {

        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select distinct l.city from Location as l");
        List<String> list = (List<String>) query.list();

        session.close();
        return list;
    }

}
