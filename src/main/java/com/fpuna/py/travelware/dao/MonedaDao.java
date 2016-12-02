/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PgeMonedas;

/**
 *
 * @author eencina
 */
public interface MonedaDao extends GenericDao<PgeMonedas, Integer>{
    PgeMonedas getByName(String value);
}
