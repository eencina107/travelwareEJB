/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComPagos;

/**
 *
 * @author damia_000
 */
public interface PagoDao extends GenericDao<ComPagos, Integer>{
    public void agregarCuotasFactura(ComFacturas fact);
    public ComPagos getCuotaAPagar(ComFacturas fact);
}
