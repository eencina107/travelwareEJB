/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ActividadDao;
import com.fpuna.py.travelware.model.ViaActividades;
import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eencina
 */
@Stateless
public class ActividadImpl implements ActividadDao{
    final static Logger logger = Logger.getLogger(ActividadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;
    
    @Override
    public ViaActividades create(ViaActividades object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la Actividad "+object.getActDet()+" del viaje con id:"+object.getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create", e);
            return null;
        }
 
    }

    public ViaActividades getById(Integer actOrd, Integer viaId) {
        try {
            return (ViaActividades) em.createQuery("Select a from ViaActividades a WHERE a.viaActividadesPK.actOrd = :actOrd AND a.viaActividadesPK.viaId = :viaId").setParameter("viaId", viaId).setParameter("actOrd", actOrd).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaActividades update(ViaActividades object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la actividad "+object.getActDet()+" del viaje con id:"+object.getViaId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaActividades object) {
        try{
            String det = object.getActDet();
            int viaId = object.getViaId().getViaId();
            em.remove(em.find(ViaActividades.class, object));
            em.flush();
            logger.info("Se elimina la actividad "+det+" del viaje con id:"+viaId);
            return true;
        } catch (Exception e){
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaActividades> getAll() {
        try {
            return em.createQuery("select d from ViaActividades d").getResultList();
        } catch (Exception e){
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return null;
        }
    }

    @Override
    public ViaActividades getById(Integer id) {
        logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ");
        throw new UnsupportedOperationException("ERROR. Acción no Soportada."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
