/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import java.io.Serializable;

/**
 *
 * @author Jonathan
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> {

    /**
     * Persist the newInstance object into database
     *
     * @param newInstance
     * @return
     */
    ID create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using
     * the indicated id as primary key
     *
     * @param id
     * @return
     */
    T read(ID id);

    /**
     * Save changes made to a persistent object.
     *
     * @param transientObject
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage in the database
     *
     * @param persistentObject
     */
    void delete(T persistentObject);
}
