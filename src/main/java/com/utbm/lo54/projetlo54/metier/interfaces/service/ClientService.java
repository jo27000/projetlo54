/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.Client;

/**
 *
 * @author Jonathan
 */
public interface ClientService extends GenericService<Client, Integer> {

    public Client getByLastName(String lastName) throws Exception;

    public Client getByFirstName(String firstName) throws Exception;

    public Client getByFirstAndLastName(String firstName, String lastName) throws Exception;

    public Client getByAddress(String address) throws Exception;

    public Client getByPhoneNumber(String phoneNumber) throws Exception;

    public Client getByMail(String email) throws Exception;

    public Client getBySessionCourseId(Integer sessionCourseId) throws Exception;

}
