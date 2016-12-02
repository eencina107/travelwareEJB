/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.FidelidadDao;
import com.fpuna.py.travelware.model.ViaFidelidades;
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
public class FidelidadImpl implements FidelidadDao{
    final static Logger logger = Logger.getLogger(FidelidadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaFidelidades create(ViaFidelidades object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la fidelidad con id:"+object.getFidId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaFidelidades getById(Integer perId, Integer orgId) {
        try {
            return (ViaFidelidades) em.createQuery("Select f from ViaFidelidades f where f.orgId = :orgId AND f.perId= :perId").setParameter("orgId", orgId).setParameter("perId", perId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaFidelidades update(ViaFidelidades object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la fidelidad con id:"+object.getFidId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaFidelidades object) {
        try {
            int fidId = object.getFidId();
            em.remove(em.find(ViaFidelidades.class, object));
            em.flush();
            logger.info("Se elimina la fidelidad con id:"+fidId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaFidelidades> getAll() {
        try {
            return em.createQuery("select f FROM ViaFidelidades f").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public ViaFidelidades getById(Integer id) {
        try {
            ViaFidelidades fid = em.find(ViaFidelidades.class, id);
            return fid;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }
    
}
