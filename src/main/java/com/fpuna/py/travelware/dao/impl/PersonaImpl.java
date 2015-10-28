/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PersonaDao;
import com.fpuna.py.travelware.model.PgePersonas;
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
public class PersonaImpl implements PersonaDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgePersonas create(PgePersonas object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la persona con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgePersonas getById(Integer id) {
        try {
            return em.find(PgePersonas.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgePersonas update(PgePersonas object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la persona con id:"+object.getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgePersonas object) {
        try {
            int id = object.getPerId();
            em.remove(em.find(PgePersonas.class,id));
            em.flush();
            logger.info("Se elimina la persona con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgePersonas> getAll() {
        try {
            return em.createQuery("SELECT p FROM PgePersonas p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
