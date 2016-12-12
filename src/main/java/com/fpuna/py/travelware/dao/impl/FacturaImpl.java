/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.FacturaDao;
import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComProveedores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author damia_000
 */
@Stateless
public class FacturaImpl implements FacturaDao {

    final static Logger logger = Logger.getLogger(FacturaImpl.class);

    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComFacturas create(ComFacturas object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el factura nro:" + object.getFacId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: create ", e);
            return null;
        }
    }

    public ComFacturas getById(Integer facId, Integer proId) {
        try {
            return (ComFacturas) em.createQuery("SELECT f from ComFacturas f WHERE f.facId = :facId AND p.proId = :proId").setParameter("proId", proId).setParameter("facId", facId).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ComFacturas update(ComFacturas object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el factura con indice: " + object.getFacId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ComFacturas object) {
        try {
            int id = object.getFacId();
            // em.remove(em.find(ComFacturas.class, id));
            object.setFacEst('A');
            em.merge(object);
            em.flush();
            logger.info("Se elimina la factura con indice: " + id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ComFacturas> getAll() {
        try {
            return em.createQuery("select f from ComFacturas f where f.facEst = \'I\' ORDER BY f.facNro").getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getAll ", e);
            return null;
        }
    }

    @Override
    public List<ComFacturas> getAllProv(ComProveedores proveedor) {
        try {
//            return em.createQuery("select f from ComFacturas f where f.proId = :proId ORDER BY f.facNro").setParameter("proId", proveedor).getResultList();
            return em.createQuery("select f from ComFacturas f where f.proId = :proId ORDER BY f.facNro").setParameter("proId", proveedor).getResultList();
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getAll(proveedor) ", e);
            return null;
        }
    }

    @Override
    public ComFacturas getById(Integer id) {
        try {
            return em.find(ComFacturas.class, id);
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ComFacturas getByName(String value) {
        try {
            return (ComFacturas) em.createNamedQuery("ComFacturas.findByFacDesc").setParameter("facDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS " + this.getClass().getName() + " METHOD: getByName " + e);
            return null;
        }
    }

    @Override
    public ComFacturas getLast() {
        try {
            return (ComFacturas) em.createQuery("Select f from ComFacturas f where f.facId = (SELECT max(f.facId) from ComFacturas f)").getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS " + this.getClass().getName() + " METHOD: getByName " + e);
            return null;
        }
    }
}
