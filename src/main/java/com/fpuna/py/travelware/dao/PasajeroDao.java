/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaViajes;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface PasajeroDao extends GenericDao<ViaPasajeros, Integer>{

    public List<ViaPasajeros> getAll(ViaViajes viajeSelected);
    public ViaPasajeros getByViaIdPerId(ViaViajes viaje, PgePersonas persona);
    
}
