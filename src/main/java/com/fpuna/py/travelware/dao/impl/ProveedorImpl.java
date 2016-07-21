/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ProveedorDao;
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
public class ProveedorImpl implements ProveedorDao{
    final static Logger logger = Logger.getLogger(ProveedorImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComProveedores create(ComProveedores object) {
        try {
            em.persist(object);
            em.flush();
            logger.info("Se inserta el proveedor con id:"+object.getProId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: create ", e);
            return null;
        }
    }

    @Override
    public ComProveedores getById(Integer id) {
        try {
            return em.find(ComProveedores.class, id);
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getById ", e);
            return null;
        }
    }

    @Override
    public ComProveedores update(ComProveedores object) {
        try {
            em.merge(object);
            em.flush();
            logger.info("Se actualiza el proveedor con id:"+object.getProId());
            return object;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: update ", e);
            return null;
        }
    }

    @Override
    public boolean delete(ComProveedores object) {
        try {
            int id = object.getProId();
            em.remove(em.find(ComProveedores.class, id));
            em.flush();
            logger.info("Se elimina el proveedor con id:"+id);
            return true;
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: delete ", e);
            return false;
        }
    }

    @Override
    public List<ComProveedores> getAll() {
        try {
            return em.createQuery("Select p from ComProveedores p  WHERE p.proEst=\'A\' ORDER BY p.proDesc").getResultList();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getAll ", e);
            return null;
        }
    }
    
    @Override
    public ComProveedores getByName(String name){
        try {
            return (ComProveedores) em.createNamedQuery("ComProveedores.findByProDesc").setParameter("proDesc", name).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS "+this.getClass().getName()+" METHOD: getByName ", e);
            return null;
        }
    }
    
}
