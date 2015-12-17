/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.TipoOrgDao;
import com.fpuna.py.travelware.model.PgeTipoOrg;
import org.apache.log4j.Logger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author eencina
 */

@Stateless
public class TipoOrgImpl implements TipoOrgDao {
    final static Logger logger = Logger.getLogger(TipoOrgImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeTipoOrg create(PgeTipoOrg object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el tipo de organizacion: "+object.getTipCodigo());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeTipoOrg getById(Integer id) {
        try {
            return em.find(PgeTipoOrg.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeTipoOrg update(PgeTipoOrg object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el tipo organizacion:"+object.getTipCodigo());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeTipoOrg object) {
        try {
            Integer id= object.getTipId();
            em.remove(em.find(PgeTipoOrg.class, id));
            logger.info("Se elimina el tipo de organizacion "+object.getTipCodigo());
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeTipoOrg> getAll() {
        try {
            return em.createQuery("SELECT t FROM PgeTipoOrg t order by t.tipCodigo").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgeTipoOrg getById(String id) {
        try {
            return em.find(PgeTipoOrg.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeTipoOrg getByName(String name) {
        try {
            return (PgeTipoOrg) em.createNamedQuery("PgeTipoOrg.findByTipDescripcion").setParameter("tipDescripcion", name).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getByName ", e);
            return null;
        }
    }
    
}
