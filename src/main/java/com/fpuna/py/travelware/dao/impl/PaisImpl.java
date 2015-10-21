/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PaisDao;
import com.fpuna.py.travelware.model.PgeOrganizaciones;
import com.fpuna.py.travelware.model.PgePaises;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class PaisImpl implements PaisDao{
    final static Logger logger = Logger.getLogger(PaisImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgePaises create(PgePaises object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el pais con id:"+object.getPaiId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgePaises getById(Integer id) {
        try {
            return em.find(PgePaises.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgePaises update(PgePaises object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el pais con id:"+object.getPaiId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgePaises object) {
        try {
            int id = object.getPaiId();
            em.remove(em.find(PgeOrganizaciones.class, id));
            em.flush();
            logger.info("Se elimina el pais con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgePaises> getAll() {
        try {
            return em.createQuery("Select p from PgePaises p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
