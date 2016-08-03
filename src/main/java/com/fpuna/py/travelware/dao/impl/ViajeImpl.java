/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ViajeDao;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaPasajeros;
import com.fpuna.py.travelware.model.ViaViajes;
import com.fpuna.py.travelware.model.ViaViajesDet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
@Stateless
public class ViajeImpl implements ViajeDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaViajes create(ViaViajes object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el viaje con id: "+object.getViaId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public ViaViajes getById(Integer id) {
        try {
            return em.find(ViaViajes.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public ViaViajes update(ViaViajes object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el viaje con id: "+object.getViaId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaViajes object) {
        try {
            int id = object.getViaId();
            em.remove(em.find(ViaViajes.class, id));
            em.flush();
            System.out.println("Se elimina el viaje con id: "+id);
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override
    public List<ViaViajes> getAll() {
        try {
            return em.createQuery("select v from ViaViajes v").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public List<ViaViajes> getAllDisp() {
        try {
            return em.createQuery("select v from ViaViajes v where v.viaCantTot > v.viaCantVend and v.viaFecSali > current_timestamp").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAllDisp "+ e);
            return null;
        }
    }

    @Override
    public List<ViaViajes> getAllFuturos() {
        try {
            return em.createQuery("select v from ViaViajes v where v.viaCantTot > 0 and v.viaFecSali > current_timestamp").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAllDisp "+ e);
            return null;
        }
    }

    @Override
    public ViaViajes getByName(String value) {
        try {
            return (ViaViajes) em.createNamedQuery("ViaViajes.findByViaDesc").setParameter("viaDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public ViaViajesDet getByViaDetId(int id) {
        try {
            return (ViaViajesDet) em.createNamedQuery("ViaViajesDet.findByVidId").setParameter("vidId", id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getByViaDetId "+ e);
            return null;
        }
    }
    
}
