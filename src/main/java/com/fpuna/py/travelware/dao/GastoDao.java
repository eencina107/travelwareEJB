/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ViaGastos;
import com.fpuna.py.travelware.model.ViaPasajeros;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface GastoDao extends GenericDao<ViaGastos, Integer>{

    List<ViaGastos> getAll(ViaPasajeros pasajeroSelected);
    
}
