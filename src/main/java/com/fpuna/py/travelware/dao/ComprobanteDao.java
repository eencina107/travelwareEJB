/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PagComprobantes;
import java.math.BigDecimal;

/**
 *
 * @author eencina
 */
public interface ComprobanteDao extends GenericDao<PagComprobantes, Integer>{
    PagComprobantes getByNroDoc(Integer nroDoc, String conc);
    BigDecimal getLastCotizacion();
    Integer getLastNroDoc();
}
