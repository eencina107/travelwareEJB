/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ProfesionDao;
import com.fpuna.py.travelware.model.PgeProfesiones;
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
public class ProfesionImpl implements ProfesionDao{
    final static Logger logger = Logger.getLogger(ProfesionImpl.class);

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeProfesiones create(PgeProfesiones object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la profesion con id:"+object.getPrfId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeProfesiones getById(Integer id) {
        try {
            return em.find(PgeProfesiones.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeProfesiones update(PgeProfesiones object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la profesion con id:"+object.getPrfId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeProfesiones object) {
        try {
            int id = object.getPrfId();
            
            em.remove(em.find(PgeProfesiones.class, id));
            em.flush();
            logger.info("Se elimina la profesion con id:"+id);
            return true;
            
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeProfesiones> getAll() {
        try {
            return em.createQuery("select p from PgeProfesiones p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
