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

    Client getByLastName(String lastName) throws Exception;

    Client getByFirstName(String firstName) throws Exception;

    Client getByFirstAndLastName(String firstName, String lastName) throws Exception;

    Client getByAddress(String address) throws Exception;

    Client getByPhoneNumber(String phoneNumber) throws Exception;

    Client getByMail(String email) throws Exception;

    Client getBySessionCourseId(Integer sessionCourseId) throws Exception;

    Integer getCountByCourseSession(Integer id);

}
