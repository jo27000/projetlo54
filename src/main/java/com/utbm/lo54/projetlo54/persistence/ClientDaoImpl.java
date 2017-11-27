/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence;

import com.utbm.lo54.projetlo54.entity.Client;
import com.utbm.lo54.projetlo54.metier.interfaces.service.ClientService;
import org.hibernate.Session;

/**
 *
 * @author Jonathan
 */
public class ClientDaoImpl implements ClientService {

    private Session session;

    @Override
    public Integer create(Client newInstance) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(newInstance);
        session.getTransaction().commit();
        session.close();
        return id;

    }

    @Override
    public Client read(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Client c = (Client) session.get(Client.class, id);
        session.close();
        return c;
    }

    @Override
    public void update(Client transientObject) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(transientObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Client persistentObject) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(persistentObject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client getByLastName(String lastName) throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        return null;
    }

    @Override
    public Client getByFirstName(String firstName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getByFirstAndLastName(String firstName, String lastName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getByAddress(String address) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getByPhoneNumber(String phoneNumber) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getByMail(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getBySessionCourseId(Integer sessionCourseId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}