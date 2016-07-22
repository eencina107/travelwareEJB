/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComProveedores;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author damia_000
 */
public interface FacturaDao extends GenericDao<ComFacturas, Integer>{
    public List<ComFacturas> getAllProv(ComProveedores proveedor);
    public ComFacturas getByName(String value);
}
