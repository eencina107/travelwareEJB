/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PasajeroDao;
import com.fpuna.py.travelware.model.ViaPasajeros;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class PasajeroImpl implements PasajeroDao{
    final static Logger logger = Logger.getLogger(PasajeroImpl.class);

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPasajeros create(ViaPasajeros object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el pasajero con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public ViaPasajeros getById(Integer id) {
        try {
            return em.find(ViaPasajeros.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaPasajeros update(ViaPasajeros object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el pasajero con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPasajeros object) {
        try {
            int id = object.getPerId();
            em.remove(em.find(ViaPasajeros.class, id));
            em.flush();
            logger.info("Se elimina el pasajero con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaPasajeros> getAll() {
        try {
            return em.createQuery("select p from ViaPasajeros p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
