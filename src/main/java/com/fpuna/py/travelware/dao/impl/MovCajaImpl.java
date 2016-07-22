/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.py.travelware.dao.impl;

import com.fpuna.py.travelware.dao.MovCajaDao;
import com.fpuna.py.travelware.model.ComMovCajas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author damia_000
 */
@Stateless
public class MovCajaImpl implements MovCajaDao{
    @PersistenceContext(unitName = "TravelwarePU")
    private EntityManager em;

    @Override
    public ComMovCajas create(ComMovCajas object) {
        try {
            em.persist(object);
            em.flush();
            System.out.println("Se inserta el movimiento con id:"+object.getMovId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: create "+e);
            return null;
        }
    }

    @Override
    public ComMovCajas getById(Integer id) {
        try {
            return em.find(ComMovCajas.class, id);
        } catch (Exception e) {
            System.out.println("ERROR:"+this.getClass().getName()+" METHOD: getById "+e);
            return null;
        }
    }

    @Override
    public ComMovCajas update(ComMovCajas object) {
        try {
            em.merge(object);
            em.flush();
            System.out.println("Se actualiza o guarda el movimiento con id:"+object.getMovId());
            return object;
        } catch (Exception e) {
            System.out.println("ERROR:"+ this.getClass().getName()+" METHOD: update "+e);
            return null;
        }
    }

    @Override
    public boolean delete(ComMovCajas object) {
        try {
            int id=object.getMovId();
            object.setMovAnulado('S');
            em.merge(object);
            em.flush();
            System.out.println("Se anula el movimiento con id:"+object.getMovId());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: delete "+e);
            return false;
        }
    }

    @Override
    public List<ComMovCajas> getAll() {
        try {
            return em.createQuery("SELECT p FROM ComMovCajas p WHERE p.movAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getAll "+e);
            return null;
        }
    }

    public List<ComMovCajas> getDebitos() {
        try {
            return em.createQuery("SELECT p FROM ComMovCajas p WHERE p.movTip=\'D\' and p.movAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getDebitos "+e);
            return null;
        }
    }

    public List<ComMovCajas> getCreditos() {
        try {
            return em.createQuery("SELECT p FROM ComMovCajas p WHERE p.movTip=\'C\' and p.movAnulado<>\'S\'").getResultList();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getCreditos "+e);
            return null;
        }
    }

    public Integer getCantAll() {
        try {
            return ((Long) em.createQuery("SELECT COUNT(p) FROM ComMovCajas p WHERE p.movAnulado<>\'S\'").getSingleResult()).intValue();
        } catch (Exception e) {
            System.out.println("ERROR: "+this.getClass().getName()+" METHOD: getCantAll "+e);
            return null;
        }
    }
}
