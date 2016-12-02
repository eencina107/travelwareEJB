/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.ConceptoDao;
import com.fpuna.py.travelware.model.ViaConceptos;
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
public class ConceptoImpl implements ConceptoDao{
    final static Logger logger = Logger.getLogger(ConceptoImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaConceptos create(ViaConceptos object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta la concepto con id:"+object.getConId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public ViaConceptos getById(Integer id) {
        try {
            return em.find(ViaConceptos.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public ViaConceptos update(ViaConceptos object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza la concepto con id:"+object.getConId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaConceptos object) {
        try {
            int id = object.getConId();
            em.remove(em.find(ViaConceptos.class, id));
            em.flush();
            System.out.println("Se elimina la concepto con el id:"+id);
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override   
    public List<ViaConceptos> getAll() {
        try {
            return em.createQuery("SELECT p from ViaConceptos p").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public List<ViaConceptos> getAllReq() {
        try {
            return em.createQuery("SELECT v from ViaConceptos v where v.conEst = \'A\' and v.conReq = \'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAllReq "+ e);
            return null;
        }
    } 

    @Override
    public ViaConceptos getByName(String value) {
        try {
            return (ViaConceptos) em.createNamedQuery("ViaConceptos.findByConDesc").setParameter("conDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getByName "+ e);
            return null;
        }
    }

    @Override
    public Integer getCantReq() {
        try {
            Long cant = (Long) em.createQuery("SELECT COUNT(v) from ViaConceptos v where v.conEst = \'A\' and v.conReq = \'S\'").getSingleResult();
            return cant.intValue();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getCantReq "+ e);
            return null;
        }
    }
    
}
