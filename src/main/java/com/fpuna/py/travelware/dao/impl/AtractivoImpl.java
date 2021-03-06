/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.AtractivoDao;
import com.fpuna.py.travelware.model.PgeAtractivos;
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
public class AtractivoImpl implements AtractivoDao {
    final static Logger logger = Logger.getLogger(AtractivoImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeAtractivos create(PgeAtractivos object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el atractivo con id: "+object.getAtrId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }
//
//    public PgeAtractivos getById(Integer paiId, Integer ciuId, Integer atrId) {
//        try {
//            return (PgeAtractivos) em.createQuery("SELECT a FROM PgeAtractivos a WHERE A.pgeAtractivosPK.paiId= :paiId and a.pgeAtractivosPK.ciuId = :ciuId and a.pgeAtractivosPK.atrId = :atrId").setParameter("paiId", paiId).setParameter("ciuId", ciuId).setParameter("atrId", atrId).getSingleResult();
//        } catch (Exception e) {
//            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
//            return null;
//        }
//    }

    @Override
    public PgeAtractivos update(PgeAtractivos object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el atractivo con id: "+object.getAtrId());
            return object;
        } catch (Exception e) {
             logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeAtractivos object) {
        try {
            int atrId = object.getAtrId();
            int ciuId = object.getCiuId().getCiuId();
            em.remove(em.find(PgeAtractivos.class, object.getAtrId()));
            em.flush();
            logger.info("Se elimina el atractivo con id: "+atrId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeAtractivos> getAll() {
        try {
            return em.createQuery("select p from PgeAtractivos p").getResultList();
        } catch (Exception e) {
             logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgeAtractivos getById(Integer id) {
        try {
            return (PgeAtractivos) em.createQuery("SELECT a FROM PgeAtractivos a WHERE a.atrId = :atrId").setParameter("atrId", id).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
        
    }
    
}
