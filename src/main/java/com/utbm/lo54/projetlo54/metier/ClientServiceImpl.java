/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier;

import com.utbm.lo54.projetlo54.entity.Client;
import com.utbm.lo54.projetlo54.metier.interfaces.service.ClientService;
import com.utbm.lo54.projetlo54.persistence.ClientDaoImpl;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ClientServiceImpl implements ClientService {

    private ClientService clientDao = new ClientDaoImpl();

    @Override
    public Integer create(Client newInstance) {
        return clientDao.create(newInstance);
    }

    @Override
    public Client read(Integer id) {
        return clientDao.read(id);
    }

    @Override
    public void update(Client transientObject) {
        clientDao.update(transientObject);
    }

    @Override
    public void delete(Client persistentObject) {
        clientDao.delete(persistentObject);
    }

    @Override
    public Client getByLastName(String lastName) throws Exception {
        return clientDao.getByLastName(lastName);
    }

    @Override
    public Client getByFirstName(String firstName) throws Exception {
        return clientDao.getByFirstName(firstName);
    }

    @Override
    public Client getByFirstAndLastName(String firstName, String lastName) throws Exception {
        return clientDao.getByFirstAndLastName(firstName, lastName);
    }

    @Override
    public Client getByAddress(String address) throws Exception {
        return clientDao.getByAddress(address);

    }

    @Override
    public Client getByPhoneNumber(String phoneNumber) throws Exception {
        return clientDao.getByPhoneNumber(phoneNumber);
    }

    @Override
    public Client getByMail(String email) throws Exception {
        return clientDao.getByMail(email);
    }

    @Override
    public Client getBySessionCourseId(Integer sessionCourseId) throws Exception {
        return clientDao.getBySessionCourseId(sessionCourseId);
    }

    @Override
    public List<Client> getAll(int index, int size, String sortField, String sortOrder) {
        return clientDao.getAll(index, size, sortField, sortOrder);
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
