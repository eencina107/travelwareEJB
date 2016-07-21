/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.CajaChicaDao;
import com.fpuna.py.travelware.model.ComCajas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author damia_000
 */
@Stateless
public class CajaChicaImpl implements CajaChicaDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComCajas create(ComCajas object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta Caja Chica");
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: create "+ e);
            return null;
        }
    }

    @Override
    public ComCajas getById(Integer id) {
        try {
            return em.find(ComCajas.class, id);
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getById "+ e);
            return null;
        }
    }

    @Override
    public ComCajas update(ComCajas object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza caja chica");
            return object;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: update "+ e);
            return null;
        }
    }

    @Override
    public boolean delete(ComCajas object) {
        try {
            int id= object.getCajId();
            em.remove(em.find(ComCajas.class, id));
            em.flush();
            return true;
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: delete "+ e);
            return false;
        }
    }

    @Override
    public List<ComCajas> getAll() {
        try {
            return em.createQuery("SELECT c from ComCajas c").getResultList();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    } 
    
    @Override
    public ComCajas getByName(String value) {
        try {
            return (ComCajas) em.createNamedQuery("ComCajas.findByCajDesc").setParameter("cajDesc", value).getSingleResult();
        } catch (Exception e) {
            System.out.println("CLASS "+this.getClass().getName()+" METHOD: getAll "+ e);
            return null;
        }
    }
}
