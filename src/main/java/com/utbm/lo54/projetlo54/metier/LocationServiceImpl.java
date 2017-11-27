/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier;

import com.utbm.lo54.projetlo54.entity.Location;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import com.utbm.lo54.projetlo54.persistence.LocationDaoImpl;

/**
 *
 * @author Jonathan
 */
public class LocationServiceImpl implements LocationService {

    private LocationService locationDao = new LocationDaoImpl();

    @Override
    public Integer create(Location newInstance) {
        return locationDao.create(newInstance);
    }

    @Override
    public Location read(Integer id) {
        return locationDao.read(id);
    }

    @Override
    public void update(Location transientObject) {
        locationDao.update(transientObject);
    }

    @Override
    public void delete(Location persistentObject) {
        locationDao.delete(persistentObject);
    }

    @Override
    public Location getByCity(String city) throws Exception {
        return locationDao.getByCity(city);
    }

}
