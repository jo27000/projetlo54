/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jonathan
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> extends Serializable {

    ID create(T newInstance);

    T read(ID id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> getAll(int index, int size, String sortField, String sortOrder);

    int getCount();
}
