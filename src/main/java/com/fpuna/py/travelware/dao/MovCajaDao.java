/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.ComMovCajas;
import java.util.List;

/**
 *
 * @author damia_000
 */
public interface MovCajaDao extends GenericDao<ComMovCajas, Integer>{
    public List<ComMovCajas> getDebitos();
    public List<ComMovCajas> getCreditos();
    
}
