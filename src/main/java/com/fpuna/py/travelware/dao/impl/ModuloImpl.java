/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ModuloDao;
import com.fpuna.py.travelware.model.PgeModulos;
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
public class ModuloImpl implements ModuloDao{
    final static Logger logger = Logger.getLogger(ModuloImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeModulos create(PgeModulos object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el modulo con id:"+object.getModId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeModulos getById(Integer id) {
        try {
            return em.find(PgeModulos.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeModulos update(PgeModulos object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el modulo con id:"+object.getModId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeModulos object) {
        try {
            int modId = object.getModId();
            em.remove(em.find(PgeModulos.class, modId));
            em.flush();
            logger.info("Se elimina el modulo con Id:"+modId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeModulos> getAll() {
        try {
            return em.createQuery("SELECT m FROM PgeModulos m").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
