/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ViaPasaportes;
import com.fpuna.py.travelware.model.ViaVisas;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface VisaDao extends GenericDao<ViaVisas, Integer>{
    List<ViaVisas> getAll(ViaPasaportes patId);
    Integer getMaxByPasaporte(ViaPasaportes pasaporte);
}
