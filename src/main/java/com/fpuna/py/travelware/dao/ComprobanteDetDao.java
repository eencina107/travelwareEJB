/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PagComprobantes;
import com.fpuna.py.travelware.model.PagComprobantesDet;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface ComprobanteDetDao extends GenericDao<PagComprobantesDet, Integer>{
    List<PagComprobantesDet> getAll(PagComprobantes comprobante);
}
