/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ViajeDetDao;
import com.fpuna.py.travelware.model.ViaConceptos;
import com.fpuna.py.travelware.model.ViaViajes;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author damia_000
 */
@Stateless
public class ViajeDetImpl implements ViajeDetDao{
    final static Logger logger = Logger.getLogger(ViajeDetImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaViajesDet create(ViaViajesDet object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el detalle del viaje con id:"+object.getVidId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ViaViajesDet getById(Integer id) {
        try {
            return em.find(ViaViajesDet.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ViaViajesDet update(ViaViajesDet object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el detalle del viaje con id: "+object.getVidId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaViajesDet object) {
        try {
            int id = object.getVidId();
            em.remove(em.find(ViaViajesDet.class, id));
            em.flush();
            System.out.println("Se elimina el detalle del viaje con id: "+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: delete"+e);
            return false;
        }
    }

    @Override
    public List<ViaViajesDet> getAll() {
        try {
            return em.createQuery("SELECT vd FROM ViaViajesDet vd").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getAll "+e);
            return null;
        }
    }

    @Override
    public List<ViaViajesDet> getAll(ViaViajes viaje) {
        try {
            return em.createQuery("SELECT vd FROM ViaViajesDet vd WHERE vd.viaId = :viaId").setParameter("viaId", viaje).getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getAll(viaje) "+e);
            return null;
        }
    }

    @Override
    public Integer getCantTotCon(ViaViajes viaje, ViaConceptos concepto) {
        try {
            //Cantidad de detalle por Concepto y Viaje
            Long cant= (Long) em.createQuery("SELECT COALESCE(SUM(vd.vidCantTot),0) FROM ViaViajesDet vd WHERE vd.viaId = :viaId and vd.conId = :conId and vd.vidTip = \'I\'").setParameter("viaId", viaje).setParameter("conId", concepto).getSingleResult();
            System.out.println("geCantTotCon: " + cant.intValue());
            return cant.intValue();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getCantTotCon(viaje, concepto) "+e);
            return null;
        }
    }
    
}
