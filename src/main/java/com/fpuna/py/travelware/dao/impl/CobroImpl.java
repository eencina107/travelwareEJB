/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.CobroDao;
import com.fpuna.py.travelware.model.PagCobros;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaViajes;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author eencina
 */
@Stateless
public class CobroImpl implements CobroDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PagCobros create(PagCobros object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el cobro con id:"+object.getCobId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public PagCobros getById(Integer id) {
        try {
            return em.find(PagCobros.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public PagCobros update(PagCobros object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza o guarda el gasto con id:"+object.getCobId());
            return object;
        } catch (ConstraintViolationException e) {
            System.out.println("ERROR Constraint: "+this.getClass().getName()+" METHOD: update "+e.getConstraintViolations().toString());
            return null;
        } catch (Exception e) {
            System.out.println("ERROR:"+ this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(PagCobros object) {
        try {
            int id=object.getCobId();
            object.setCobAnulado('S');
            em.merge(object);
            em.flush();
            System.out.println("Se anula el cobro con id:"+object.getCobId());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: delete "+e);
            return false;
        }
    }

    @Override
    public List<PagCobros> getAll() {
        try {
            return em.createQuery("SELECT c FROM PagCobros c WHERE c.cobAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getAll "+e);
            return null;
        }
    }
    
    @Override
    public List<PagCobros> getAll(ViaViajes viajeSelected) {
        try {
            return em.createQuery("select c from PagCobros c WHERE c.viaId=:viaId").setParameter("viaId", viajeSelected).getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll(viajeSelected) "+ e);
            return null;
        }
    }
    
    @Override
    public BigDecimal getMontoPagado(PgePersonas persona, ViaViajes viaje) {
        try {
            //Monto pagado por persona y viaje (todos la misma moneda)
            BigDecimal monto= (BigDecimal) em.createQuery("SELECT COALESCE(SUM(c.cobMonto),0) FROM PagCobros c WHERE c.viaId = :viaId and c.perId = :perId and c.cobAnulado<>\'S\' and c.cobEstado=\'P\'").setParameter("viaId", viaje).setParameter("perId", persona).getSingleResult();
            System.out.println("cobMonto: " + monto);
            return monto;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getMontoPagado(personas, viaje) "+e);
            return null;
        }
    }

    @Override
    public BigDecimal getMaxCuota(PgePersonas persona, ViaViajes viaje) {
        try {
            //Maximo de cuotas por persona y viaje
            BigDecimal cuota= new BigDecimal((Long)em.createQuery("SELECT COALESCE(COUNT(c.cobNro), 0) FROM PagCobros c WHERE c.viaId = :viaId and c.perId = :perId").setParameter("viaId", viaje).setParameter("perId", persona).getSingleResult());
            System.out.println("cobMonto: " + cuota);
            return cuota;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getMaxCuota(personas, viaje) "+e);
            return null;
        }
    }

    @Override
    public BigDecimal getMinCuoIngresado(PgePersonas persona, ViaViajes viaje) {
        try {
            //Minima cuota ingresada por persona y viaje
            BigDecimal cuota= new BigDecimal((String)em.createQuery("SELECT COALESCE(MIN(c.cobNro), '0') FROM PagCobros c WHERE c.viaId = :viaId and c.perId = :perId and c.cobAnulado<>\'S\' and c.cobEstado=\'I\'").setParameter("viaId", viaje).setParameter("perId", persona).getSingleResult());
            System.out.println("cuota: " + cuota);
            return cuota;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getMinCuoIngresado(personas, viaje) "+e);
            return null;
        }
    }

    @Override
    public String getSeqFacNro() {
        try {
            //Secuencia de Nro. de Factura
            String facturaNro= Long.toString((Long)em.createNativeQuery("SELECT nextval('pag_cobros_cob_fac_nro_seq') as num").getSingleResult());
            System.out.println("facturaNro: " + facturaNro);
            return facturaNro;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getSeqFacNro() "+e);
            return null;
        }
    }

    @Override
    public String getSeqNcrNro() {
        try {
            //Secuencia de Nota de Credito
            String facturaNro= Long.toString((Long)em.createNativeQuery("SELECT nextval('pag_cobros_cob_ncr_nro_seq') as num").getSingleResult());
            System.out.println("notCreNro: " + facturaNro);
            return facturaNro;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getSeqNcrNro() "+e);
            return null;
        }
    }
}
