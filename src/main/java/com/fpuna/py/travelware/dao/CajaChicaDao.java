/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComCajas;
import java.io.Serializable;

/**
 *
 * @author damia_000
 */
public interface CajaChicaDao extends GenericDao<ComCajas, Integer>{
    ComCajas getByName(String value);
    
}
