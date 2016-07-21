/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.FacturaDetDao;
import com.fpuna.py.travelware.model.ComFacturas;
import com.fpuna.py.travelware.model.ComFacturasDet;
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
public class FacturaDetImpl implements FacturaDetDao{
    final static Logger logger = Logger.getLogger(FacturaDetImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComFacturasDet create(ComFacturasDet object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el detalle de la factura con id:"+object.getFadId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ComFacturasDet getById(Integer id) {
        try {
            return em.find(ComFacturasDet.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ComFacturasDet update(ComFacturasDet object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza el detalle de la factura con id: "+object.getFadId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ComFacturasDet object) {
        try {
            int id = object.getFadId();
            em.remove(em.find(ComFacturasDet.class, id));
            em.flush();
            System.out.println("Se elimina el detalle de la factura con id: "+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: delete"+e);
            return false;
        }
    }

    @Override
    public List<ComFacturasDet> getAll() {
        try {
            return em.createQuery("SELECT fd FROM ComFacturasDet fd").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall "+e);
            return null;
        }
    }

    @Override
    public List<ComFacturasDet> getAllNoUti() {
        try {
            return em.createQuery("SELECT fd FROM ComFacturasDet fd WHERE fd.conId is not null AND fd.fadUti <> \'S\' ORDER BY fd.fadId").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getAllNoUti "+e);
            return null;
        }
    }

    @Override
    public List<ComFacturasDet> getAll(ComFacturas factura) {
        try {
            return em.createQuery("SELECT fd FROM ComFacturasDet fd WHERE fd.facId=:facId ORDER BY fd.fadNroSec").setParameter("facId", factura).getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall(factura) "+e);
            return null;
        }
    }

    @Override
    public Integer getMaxByFactura(ComFacturas factura) {
        try {
            Long cant= (Long) em.createQuery("SELECT COUNT(fd) FROM ComFacturasDet fd WHERE fd.facId=:facId").setParameter("facId", factura).getSingleResult();
            return cant.intValue();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getMaxByFactura "+e);
            return null;
        }
    }
    
    @Override
    public ComFacturasDet getByName(String value) {
        try {
            return (ComFacturasDet) em.createNamedQuery("ComFacturasDet.findByFadDesc").setParameter("fadDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getByName "+ e);
            return null;
        }
    }
    
}
