/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComFacturasDet;
import java.util.List;

/**
 *
 * @author damia_000
 */
public interface FacturaDetDao extends GenericDao<ComFacturasDet, Integer>{
    List<ComFacturasDet> getAll(ComFacturas factura);
    List<ComFacturasDet> getAllNoUti();
    Integer getMaxByFactura(ComFacturas factura);
    public ComFacturasDet getByName(String value);
}
