/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.PasaporteDao;
import com.fpuna.py.travelware.model.PgePersonas;
import com.fpuna.py.travelware.model.ViaPasaportes;
import java.util.Date;
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
public class PasaporteImpl implements PasaporteDao{
    final static Logger logger = Logger.getLogger(PasaporteImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaPasaportes create(ViaPasaportes object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el pasaporte nro:"+object.getPatId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    public ViaPasaportes getById(Integer nroSec, Integer perId) {
        try {
            return (ViaPasaportes) em.createQuery("SELECT p from ViaPasaportes p WHERE P.patNroSec = :nroSec AND p.perId = :perId").setParameter("perId", perId).setParameter("nroSec", nroSec).getSingleResult();
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
            logger.info("Se actualiza el pasaporte con indice:"+object.getPatId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaPasaportes object) {
        try {
            int perId = object.getPerId().getPerId();
            em.remove(em.find(ViaPasaportes.class, object.getPatId()));
            logger.info("Se elimina el pasaporte de la persona con id:"+perId);
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
    public List<ViaPasaportes> getAll(PgePersonas personaSelected) {
        try {
            return em.createQuery("select p from ViaPasaportes p WHERE p.perId=:perId").setParameter("perId", personaSelected).getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll(personaSelected) ", e);
            return null;
        }
    }
    @Override
    public Integer getCantPasaportes(PgePersonas personaSelected) {
        try {
            Long cant= (Long) em.createQuery("select COUNT(p) from ViaPasaportes p WHERE p.perId=:perId").setParameter("perId", personaSelected).getSingleResult();
            return cant.intValue();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getCantPasaportes(personaSelected) "+ e);
            return null;
        }
    }

    @Override
    public ViaPasaportes getById(Integer id) {
        try {
            return em.find(ViaPasaportes.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public Long getCantPasaportesVencidos(Date fecha) {
        try {
            return (Long) em.createQuery("SELECT COUNT(p) FROM ViaPasaportes p WHERE p.patFecVen >= :fecha")
                    .setParameter("fecha", fecha)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getCantPasaportesVencidos ", e);
            return null;
        }
    }

    @Override
    public List<ViaPasaportes> getListaVencidos(Date fecha) {
        try {
            return em.createQuery("SELECT p FROM ViaPasaportes p WHERE p.patFecVen <= :fecha")
                    .setParameter("fecha", fecha)
                    .getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getCantPasaportesVencidos ", e);
            return null;
        }
    }
    
}
