/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.MonedaDao;
import com.fpuna.py.travelware.model.PgeMonedas;
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
public class MonedaImpl implements MonedaDao{
    final static Logger logger = Logger.getLogger(MonedaImpl.class);
    
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public PgeMonedas create(PgeMonedas object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta la moneda con id:"+object.getMonId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public PgeMonedas getById(Integer id) {
        try {
            return em.find(PgeMonedas.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public PgeMonedas update(PgeMonedas object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza la moneda con id:"+object.getMonId());
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(PgeMonedas object) {
        try {
            int id = object.getMonId();
            em.remove(em.find(PgeMonedas.class, id));
            em.flush();
            System.out.println("Se elimina la moneda con el id:"+id);
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override   
    public List<PgeMonedas> getAll() {
        try {
            return em.createQuery("SELECT p from PgeMonedas p").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }

    @Override
    public PgeMonedas getByName(String value) {
        try {
            return (PgeMonedas) em.createNamedQuery("PgeMonedas.findByMonDesc").setParameter("monDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getByName "+ e);
            return null;
        }
    }
    
}
