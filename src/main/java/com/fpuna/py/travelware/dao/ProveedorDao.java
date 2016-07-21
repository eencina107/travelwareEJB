/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComProveedores;

/**
 *
 * @author damia_000
 */
public interface ProveedorDao extends GenericDao<ComProveedores, Integer>{
    public ComProveedores getByName(String name);
}
