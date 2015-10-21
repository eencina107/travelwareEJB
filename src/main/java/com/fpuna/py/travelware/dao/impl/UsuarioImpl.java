/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.UsuarioDao;
import com.fpuna.py.travelware.model.PgeUsuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class UsuarioImpl implements UsuarioDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeUsuarios create(PgeUsuarios object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el disertante con id:"+object.getUsuId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeUsuarios getById(Integer id) {
        try {
            return em.find(PgeUsuarios.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeUsuarios update(PgeUsuarios object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el usuario con el id:"+object.getUsuId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeUsuarios object) {
        try {
            int id = object.getUsuId();
            
            em.remove(em.find(PgeUsuarios.class, id));
            em.flush();
            logger.info("Se elimina el usuario con el id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeUsuarios> getAll() {
        try {
            return em.createQuery("SELECT u from PgeUsuarios u").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
