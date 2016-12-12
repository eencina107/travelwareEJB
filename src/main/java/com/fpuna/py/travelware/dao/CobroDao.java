/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao;

import com.fpuna.py.travelware.model.PagCobros;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author eencina
 */
public interface CobroDao extends GenericDao<PagCobros, Integer>{
    BigDecimal getMontoPagado(PgePersonas persona, ViaViajes viaje);
    public List<PagCobros> getAll(ViaViajes viajeSelected);
    BigDecimal getMaxCuota(PgePersonas persona, ViaViajes viaje);
    BigDecimal getMinCuoIngresado(PgePersonas persona, ViaViajes viaje);
    String getSeqFacNro();
    String getSeqNcrNro();
}
