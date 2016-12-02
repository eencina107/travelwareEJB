/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaPasaportes;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface PasaporteDao extends GenericDao<ViaPasaportes, Integer>{
    public List<ViaPasaportes> getAll(PgePersonas persona);
    public Integer getCantPasaportes(PgePersonas persona);
    public Long getCantPasaportesVencidos(Date fecha);
    public List<ViaPasaportes> getListaVencidos(Date fecha);
}
