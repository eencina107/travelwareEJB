/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ViajeDao;
import com.fpuna.py.travelware.model.ViaViajes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class ViajeImpl implements ViajeDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaViajes create(ViaViajes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el viaje con id: "+object.getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public ViaViajes getById(Integer id) {
        try {
            return em.find(ViaViajes.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaViajes update(ViaViajes object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el viaje con id: "+object.getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaViajes object) {
        try {
            int id = object.getViaId();
            em.remove(em.find(ViaViajes.class, id));
            em.flush();
            logger.info("Se elimina el viaje con id: "+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaViajes> getAll() {
        try {
            return em.createQuery("select v from ViaViajes v").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
