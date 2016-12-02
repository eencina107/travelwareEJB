/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.VisaDao;
import com.fpuna.py.travelware.model.ViaPasaportes;
import com.fpuna.py.travelware.model.ViaVisas;
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
public class VisaImpl implements VisaDao{
    final static Logger logger = Logger.getLogger(VisaImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ViaVisas create(ViaVisas object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta la visa con id:"+object.getVisId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ViaVisas getById(Integer id) {
        try {
            return em.find(ViaVisas.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ViaVisas update(ViaVisas object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza la visa con id: "+object.getVisId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ViaVisas object) {
        try {
            int id = object.getVisId();
            em.remove(em.find(ViaVisas.class, id));
            em.flush();
            System.out.println("Se elimina la visa con id: "+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: delete"+e);
            return false;
        }
    }

    @Override
    public List<ViaVisas> getAll() {
        try {
            return em.createQuery("SELECT v FROM ViaVisas v").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall "+e);
            return null;
        }
    }

    @Override
    public List<ViaVisas> getAll(ViaPasaportes patId) {
        try {
            return em.createQuery("SELECT v FROM ViaVisas v WHERE v.patId=:patId ORDER BY v.visNroSec").setParameter("patId", patId).getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getall "+e);
            return null;
        }
    }

    @Override
    public Integer getMaxByPasaporte(ViaPasaportes pasaporte) {
        try {
            Long cant= (Long) em.createQuery("SELECT COUNT(v) FROM ViaVisas v WHERE v.patId=:patId").setParameter("patId", pasaporte).getSingleResult();
            return cant.intValue();
        } catch (Exception e) {
            System.out.println("ERROR: CLASS "+this.getClass().getName()+" METHOD: getMaxByPasaporte "+e);
            return null;
        }
    }
    
}
