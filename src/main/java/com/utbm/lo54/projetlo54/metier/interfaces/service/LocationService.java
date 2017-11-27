/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.metier.interfaces.service;

import com.utbm.lo54.projetlo54.entity.Location;

/**
 *
 * @author Jonathan
 */
public interface LocationService extends GenericService<Location, Integer> {

    public Location getByCity(String city) throws Exception;

}
