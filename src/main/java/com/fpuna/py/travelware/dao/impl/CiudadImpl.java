/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.CiudadDao;
import com.fpuna.py.travelware.model.PgeCiudades;
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
public class CiudadImpl implements CiudadDao{
    final static Logger logger = Logger.getLogger(CiudadImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeCiudades create(PgeCiudades object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta la ciudad con id:"+object.getCiuId()+" del país con id:"+object.getPaiId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public PgeCiudades getById(Integer paiId, Integer ciuId) {
        try {
            return (PgeCiudades) em.createQuery("Select c from PgeCiudades c WHERE c.ciuId = :ciu_id").setParameter("ciu_id", ciuId).getSingleResult();            
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public PgeCiudades update(PgeCiudades object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza la ciudad con id:"+object.getCiuId()+" del pais con el id:"+object.getPaiId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeCiudades object) {
        try {
            int ciuId = object.getCiuId();
            int paiId = object.getPaiId().getPaiId();
            em.remove(em.find(PgeCiudades.class, ciuId));
            em.flush();
            logger.info("Se elimina la ciudad con id:"+ciuId+" del pais con id: "+paiId);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<PgeCiudades> getAll() {
        try {
            return em.createQuery("select p from PgeCiudades p").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public PgeCiudades getById(Integer id) {
        try {
            return em.find(PgeCiudades.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }
    
    @Override
    public int getMaxId(){
        return (int) em.createNativeQuery("SELECT MAX(CIU_ID) FROM PGE_CIUDADES").getSingleResult();
    }
}
