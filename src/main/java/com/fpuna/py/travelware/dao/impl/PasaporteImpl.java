/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PasajeroDao;
import com.fpuna.py.travelware.dao.PasaporteDao;
import com.fpuna.py.travelware.model.ViaPasaportes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author eencina
 */
public class PasaporteImpl implements PasaporteDao{
    final static Logger logger = Logger.getLogger(PasaporteImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPasaportes create(ViaPasaportes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el pasaporte nro:"+object.getViaPasaportesPK().getPatNroSec()+" de la persona con id:"+object.getViaPasaportesPK().getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaPasaportes getById(Integer nroSec, Integer perId) {
        try {
            return (ViaPasaportes) em.createQuery("SELECT p from ViaPasaportes p WHERE P.viaPasaportesPK.patNroSec = :nroSec AND p.viaPasaportesPK.perId = :perId").setParameter("perId", perId).setParameter("nroSec", nroSec).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ViaPasaportes update(ViaPasaportes object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el pasaporte con indice:"+object.getViaPasaportesPK().getPatNroSec()+" de la persona con id:"+object.getViaPasaportesPK().getPerId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPasaportes object) {
        try {
            int perId = object.getViaPasaportesPK().getPerId();
            int nroSec = object.getViaPasaportesPK().getPatNroSec();
            em.remove(em.find(ViaPasaportes.class, object));
            logger.info("Se elimina el pasaporte con indice:"+nroSec+" de la persona con id:"+perId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ViaPasaportes> getAll() {
        try {
            return em.createQuery("select p from ViaPasaportes p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public ViaPasaportes getById(Integer id) {
        throw new UnsupportedOperationException("ERROR. Metodo no soportado."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
