/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.RolDao;
import com.fpuna.py.travelware.model.PgeRoles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class RolImpl implements RolDao{
    final static Logger logger = Logger.getLogger(RolImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeRoles create(PgeRoles object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el rol con id:"+object.getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeRoles getById(Integer id) {
        try {
            return em.find(PgeRoles.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeRoles update(PgeRoles object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el rol con el id:"+object.getRolId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeRoles object) {
        try {
            int id = object.getRolId();
            
            em.remove(em.find(PgeRoles.class, id));
            em.flush();
            logger.info("Se elimina el rol con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeRoles> getAll() {
        try {
            return em.createQuery("select r from PgeRoles r").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
