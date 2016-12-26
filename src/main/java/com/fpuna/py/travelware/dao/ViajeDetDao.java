/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ViaConceptos;
import com.fpuna.py.travelware.model.ViaViajes;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.List;

/**
 *
 * @author damia_000
 */
public interface ViajeDetDao extends GenericDao<ViaViajesDet, Integer>{
    List<ViaViajesDet> getAll(ViaViajes viajes);
    Integer getCantTotCon(ViaViajes viaje, ViaConceptos concepto);
    ViaViajesDet getByName(String name);
}
