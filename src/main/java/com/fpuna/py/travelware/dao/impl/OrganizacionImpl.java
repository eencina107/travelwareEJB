/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.OrganizacionDao;
import com.fpuna.py.travelware.model.PgeOrganizaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class OrganizacionImpl implements OrganizacionDao{
    final static Logger logger = Logger.getLogger(OrganizacionImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeOrganizaciones create(PgeOrganizaciones object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la organizacion con id:"+object.getOrgId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeOrganizaciones getById(Integer id) {
        try {
            return em.find(PgeOrganizaciones.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeOrganizaciones update(PgeOrganizaciones object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la organizacion con id:"+object.getOrgId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeOrganizaciones object) {
        try {
            int id = object.getOrgId();
            em.remove(em.find(PgeOrganizaciones.class, id));
            em.flush();
            logger.info("Se elimina la organizacion con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeOrganizaciones> getAll() {
        try {
            return em.createQuery("select o from PgeOrganizaciones o").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
}
