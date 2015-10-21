/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.MonedaDao;
import com.fpuna.py.travelware.model.PgeMonedas;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class MonedaImpl implements MonedaDao{
    final static Logger logger = Logger.getLogger(MonedaImpl.class);
    private EntityManager em;

    @Override
    public PgeMonedas create(PgeMonedas object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la moneda con id:"+object.getMonId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeMonedas getById(Integer id) {
        try {
            return em.find(PgeMonedas.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeMonedas update(PgeMonedas object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la moneda con id:"+object.getMonId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeMonedas object) {
        try {
            int id = object.getMonId();
            em.remove(em.find(PgeMonedas.class, id));
            em.flush();
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeMonedas> getAll() {
        try {
            return em.createQuery("SELECT m FROM PgeMonedas m").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
